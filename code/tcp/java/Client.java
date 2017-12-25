import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/*
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        Socket   socket = null;   //客户端Socket
        
        OutputStream         outputStream = null; //输出流，向服务器端发送信息
        DataOutputStream dataOutputStream = null;
        
        InputStream         inputStream = null;   //输入流，读取服务器端的响应信息
        DataInputStream dataInputStream = null;
        
        BufferedReader consoleBR = null;
        
        try {
            // 创建客户端Socket，指定服务器地址和端口
            socket = new Socket("localhost", 8888);
            
            // 获取输出流，向服务器端发送信息
            outputStream     = socket.getOutputStream(); //字节输出流
            dataOutputStream = new DataOutputStream(outputStream);

            // 获取输入流
            inputStream     = socket.getInputStream();    
            dataInputStream = new DataInputStream(inputStream);
            
            // 获取控制台输入，不用Scanner，因为Scanner可以以空格结束
            consoleBR = new BufferedReader(new InputStreamReader(System.in ));
   
            while(true) {
                
                // 获取控制台输入
                String read = null;
                while (true) {
                    System.out.print("请输入你要对服务端说的话：");
                    read = consoleBR.readLine();
                    if (read!=null && !read.equals("")) {
                        break;
                    }
                }
                                                
                // 向服务端发送数据
                dataOutputStream.write(read.getBytes("UTF-8"));
                dataOutputStream.flush();
                
                if (read.equals("quit")) {
                    break;
                }
                
                // 读取服务器端的响应信息
                byte b[] = new byte[1024];
                dataInputStream.read(b);               
                String info = new String(b);
                System.out.println("我是客户端，服务器说："+info);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (socket != null) {
                    socket.shutdownInput();//关闭输入流
                    socket.shutdownOutput();//关闭输出流
                }
                if (consoleBR != null) {
                    consoleBR.close();
                }
                if(dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if(outputStream != null) {
                    outputStream.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if(inputStream != null) {
                    inputStream.close();
                }
                if(socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}