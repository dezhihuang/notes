#include<winsock2.h>
#include<stdio.h>
int main() {
  SOCKET sockfd;
  int len;
  struct sockaddr_in address;
  int result;
  char ch = 'A';
 
  WSADATA wsadata;
  if(WSAStartup(0x101,(LPWSADATA)&wsadata) != 0) {
    printf("Winsock Error\n"); 
    exit(1);
  }
  sockfd = socket(AF_INET, SOCK_STREAM, 0);
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = inet_addr("127.0.0.1");
  address.sin_port = 9734;
  len = sizeof(address);
 
  result = connect(sockfd, (struct sockaddr *)&address, len);  
  if(result == -1) {
    printf("Connetc Error");
    exit(1);
  }
 
  send(sockfd, &ch, 1, 0);
  recv(sockfd, &ch, 1, 0);
  printf("char from server = %c\n", ch);
  closesocket(sockfd);
  exit(0);
}