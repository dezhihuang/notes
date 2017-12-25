#include<sys/types.h>  
#include<sys/socket.h>  
#include<netinet/in.h>  
#include<stdio.h>  
#include<string.h>  
#include<unistd.h>  
#include<pthread.h>  
#include<stdlib.h>  
  
#define PORT 10000  
  
void thread_process(const int * socketid)  
{  
    int cid = *socketid;  
    char buffer[1024] = {0};  
    int iLen = -1;  
      
    while(1)  
    {  
        bzero(buffer,sizeof(buffer));  
          
        //5.接收客户端发来的消息  
        iLen = recv(cid,buffer,sizeof(buffer),0);  
        if(iLen < 0)  
        {  
            perror("recv");  
            exit(-1);  
        }  
        else   
        {  
            buffer[iLen] = 0;//加结束符  
            printf("Receive: %s\n",buffer);  
        }  
          
        bzero(buffer,sizeof(buffer));  
        strcpy(buffer, "Welcome to access the server!");  
        //6.发送消息给客户端  
        iLen = send(cid,buffer,strlen(buffer),0);  
        if(iLen < 0)  
        {  
            perror("send");  
            exit(-1);  
        }  
    }  
      
    close(cid);   
}  
  
int main()  
{  
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
  
    while(1)  
    {  
        //4.接受客户端的连接  
        int addrsize = sizeof(struct sockaddr_in);  
        int cid = accept(sid,(struct sockaddr *)&caddr,&addrsize);  
        if(cid < 0)  
        {  
            perror("accept");  
            exit(-1);  
        }  
          
        //创建线程  
        pthread_t tid;  
        int err = pthread_create(&tid,NULL,(void*)thread_process,(void*)&cid);  
        if (err != 0)  
        {  
            printf("can't create thread: %s\n", strerror(err));  
            exit(-1);  
        }          
    }  
      
    //7.关闭套接字  
    close(sid);  
}  
