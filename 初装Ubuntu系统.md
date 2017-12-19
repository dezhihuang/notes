# 一、设置root密码
    sudo passwd


# 二、更新系统
    sudo apt-get update //更新软件源
    sudo apt-get dist-upgrade //更新所有的软件
    
    
# 三、安装以下软件
	sudo apt install vim
	sudo apt install net-tools
	sudo apt install tree


# 四、安装ssh服务器，root登陆
    1.安装openssh server
        sudo apt-get install openssh-server
    2.配置root登录
        sudo vim /etc/ssh/sshd_config
        找到PermitRootLogin no(或者 PermitRootLogin prohibit-password)一行，去掉#号，改为PermitRootLogin yes
    3.启动或重启ssh服务
        sudo service ssh start
        sudo service ssh restart


# 五、安装samba服务器，root登陆
    1.终端输入：
        sudo apt-get install samba samba-common

    2.修改配置文件
        sudo vim /etc/samba/smb.conf

        在文尾添加：
            [file_name]			//共享文件夹名
                path = /root/share		//共享文件夹路径
                writeable = yes		//共享文件夹可写
                valid users = root

    3.设置root用户的smb服务访问密码，输入命令:

                 sudo smbpasswd -a root
            
             输入密码。		    

    4.重启samba服务
        sudo service smbd restart

    5.Windows下访问
        快捷键：Win+R
        输入：\\IP地址       示例：\\192.168.1.118

    6.输入用户名root和密码


# 六、安装XAMPP5.6.31(PHP5.6.31)
    1.安装 
        chmod 755 xampp-linux-x64-5.6.31-0-installer.run
        sudo ./xampp-linux-x64-5.6.31-0-installer.run
    2.配置XAMPP网页路径。
        sudo vim /opt/lampp/etc/httpd.conf
        将以下两句更改：
            DocumentRoot "/opt/lampp/htdocs"        ==>   DocumentRoot "/home/hdz/www" 
            <Directory "/opt/lampp/htdocs">         ==>   <Directory "/home/hdz/www">          
    3.解决MySQL数据库中文乱码问题。
        sudo vim /opt/lampp/etc/my.cnf
        (1)在下面语句后添加：character-set-server = utf8
            # The MySQL server
            [mysqld]
            port= 3306
        (2)在下面语句后添加：default-character-set = utf8
            [mysql]
            no-auto-rehash
        
    4.将bin目录加到环境变量中。
        export PATH=/opt/lampp/bin:$PATH
        
    5.启动XAMPP
        sudo /opt/lampp/lampp start

       
# 七、安装Python相关
    sudo apt install python-pip
    sudo apt install ipython
    sudo apt-get install python-mysqldb
        
        
        
        
        