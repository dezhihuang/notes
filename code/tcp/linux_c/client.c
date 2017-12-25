#include<sys/types.h>  
#include<sys/socket.h>  
#include<netinet/in.h>  
#include<stdio.h>  
#include<string.h>  
#include<stdlib.h>   
#include <unistd.h>  
#include <arpa/inet.h>  
  
#define PORT 10000  
#define IP "192.168.1.101"  
  
int main(){  
    //1.�����׽���  
    int cid = socket(AF_INET,SOCK_STREAM,0);  
    if(cid < 0 ){  
        perror("socket");  
        exit(-1);  
    }  
      
    struct sockaddr_in saddr;  
    saddr.sin_family = AF_INET;  
    saddr.sin_port = htons(PORT);  
    saddr.sin_addr.s_addr = inet_addr(IP);  
  
    //2.���ӷ�����  
    int iRet = connect(cid,(struct sockaddr*)&saddr,sizeof(struct sockaddr));  
    if(iRet < 0 ){  
        perror("connect");  
        exit(-1);  
    }  
      
    char buffer[100] = {0};  
    int len = -1;  
  
    while(strncmp(buffer,"quit",4) != 0){  
        bzero(buffer,sizeof(buffer));  
        fgets(buffer,1024,stdin);  
          
        //3.������Ϣ��������  
        len = send(cid,buffer,strlen(buffer),0);  
        if(len < 0)  
        {  
            perror("send");  
            exit(-1);  
        }  
          
          
        bzero(buffer,sizeof(buffer));  
          
        //4.���շ������Ļ�Ӧ  
        len = recv(cid,buffer,sizeof(buffer),0);  
        if(len < 0)  
        {  
            perror("recv");  
            exit(-1);  
        }  
        else   
        {  
            buffer[len] = 0;//�ӽ�����  
            printf("\nReceive: %s\n",buffer);  
        }         
    }  
      
    //5.�ر��׽���  
    close(cid);  
} 
