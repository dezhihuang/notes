#include <sys/types.h>  
#include <sys/socket.h>  
#include <netinet/in.h>  
#include <stdio.h>  
#include <string.h>  
#include <arpa/inet.h>  
#include <unistd.h>  
#include <stdlib.h>  
  
#define PORT 10000  
  
int main(){  
    //1.创建套接字  
    int sid = socket(AF_INET,SOCK_STREAM,0);  
    if(sid < 0 ){  
        perror("socket");  
        exit(-1);  
    }  
  
    struct sockaddr_in saddr,caddr;  
    saddr.sin_family = AF_INET;  
    saddr.sin_port = htons(PORT);  
    saddr.sin_addr.s_addr = INADDR_ANY;  
      
    //2.绑定本地地址和端口号  
    int iRet = bind(sid,(struct sockaddr*)&saddr,sizeof(saddr));  
    if(iRet != 0){  
        perror("bind");  
        exit(-1);  
    }  
  
    //3.侦听客户端的连接  
    iRet = listen(sid,5);  
    if(iRet != 0){  
        perror("listen");  
        exit(-1);  
    }  
  
    //4.接受客户端的连接  
    int addrsize = sizeof(struct sockaddr_in);  
    int pid = accept(sid,(struct sockaddr *)&caddr,&addrsize);  
    if(pid < 0){  
        perror("accept");  
        exit(-1);  
    }  
  
    char buffer[1024] = {0};  
    int len = -1;  
      
    while(1){  
        bzero(buffer,sizeof(buffer));  
  
        //5.接收客户端发送的消息  
        len = recv(pid,buffer,sizeof(buffer),0);  
        if(len < 0)  
        {  
            perror("recv");  
            exit(-1);  
        }  
        else   
        {  
            buffer[len] = 0;//加结束符  
            printf("Receive: %s\n",buffer);  
        }  
  
        bzero(buffer,sizeof(buffer));  
        strcpy(buffer, "Welcome to access the server!");  
          
        //6.发送消息给客户端  
        len = send(pid,buffer,strlen(buffer),0);  
        if(len < 0){  
            perror("send");  
            exit(-1);  
        }  
    }  
    close(pid);  
    close(sid);  
  
    return 0;  
} 