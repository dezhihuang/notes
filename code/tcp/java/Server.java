import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket=null;
            //记录客户端的数量
            int count=0;
            
            System.out.println("\n***服务器即将启动，等待客户端的连接***");
            
            //循环监听等待客户端的连接
            while(true){
                //调用accept()方法开始监听，等待客户端的连接
                socket=serverSocket.accept();
                
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                
                //启动线程
                serverThread.start();

                count++;//统计客户端的数量
                System.out.println("客户端的数量："+count);
                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    /*
    * 服务器线程处理类
    */
    public static class ServerThread extends Thread {
        // 和本线程相关的Socket
        Socket socket = null;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        //线程执行的操作，响应客户端的请求
        public void run(){
            InputStream       inputStream      = null;
            DataInputStream   dataInputStream  = null;
            OutputStream      outputStream     = null;
            DataOutputStream  dataOutputStream = null;
            try {
                //获取输入流，并读取客户端信息
                inputStream     = socket.getInputStream();
                dataInputStream = new DataInputStream(inputStream);
                
                //获取输出流，响应客户端的请求
                outputStream = socket.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);
                
                while (true) {
                    //循环读取客户端的信息
                    byte b[] = new byte[1024];
                    b[0] = '\0';
                    dataInputStream.read(b);               
                    String info = new String(b);
                    System.out.println("我是服务器，客户端说："+info);
                    
                    if (info.trim().equals("quit")) {
                        break;
                    }
                    
                    dataOutputStream.write("欢迎您！".getBytes("UTF-8"));
                    dataOutputStream.flush();//调用flush()方法将缓冲输出
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                //关闭资源
                try {
                    if(socket != null) {
                        socket.shutdownInput();//关闭输入流
                        socket.shutdownOutput();//关闭输出流
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
}