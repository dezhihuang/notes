# -*- coding:utf-8 -*-

import sys
import socket
import argparse

def test_client(host, port):
    
    # 创建TCP套接字
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # 连接服务器
    srv_addr = (host, port)
    sock.connect(srv_addr)
    
    # 发送并接收数据
    try:
        # 发送消息
        while True:
            # 输入消息
            msg = raw_input("Please input:")
            
            # 发送消息
            sock.sendall(msg+"\r\n")         
            
            # 接收消息
            data = sock.recv(1024)
            print "Message from server: %s" % data
            
            # 退出循环
            if msg=="exit":
                break  
        sock.close()
    except socket.errno, e:
        print "Socket error: %s" % str(e)
    except Exception as e:
        print "Other exception: %s" % str(e)
    finally:
        sock.close()
        
if __name__ == "__main__":
    host = "127.0.0.1"
    port = 9999
    test_client(host, port)        
        
 