## 挂载SD卡
三力车机挂载SD卡：mount /dev/mmcblk0p1 /mnt && cd /mnt
>瑞萨车机进入SD卡：cd /media/sd
>或者挂载到mnt目录：mount /dev/mmcblk1p1 /mnt && cd /mnt


## QtCreator下载
[https://download.qt.io/official_releases/qtcreator/](https://download.qt.io/official_releases/qtcreator/)


## QtCreator2.4下载
[https://download.qt.io/archive/qtcreator/2.4/](https://download.qt.io/archive/qtcreator/2.4/)


## Qt下载地址
[https://download.qt.io/archive/qt/](https://download.qt.io/archive/qt/)


## Qt4.7下载地址
[https://download.qt.io/archive/qt/4.7/](https://download.qt.io/archive/qt/4.7/)


## 设置Ubuntu 14.04右键终端
``` sudo apt-get install nautilus-open-terminal ```


## 将.tar.gz解压到指定目录
``` sudo tar -zxvf *.tar.gz -C 指定目录名 ```

<br>
<hr>
<hr>
<br>

## 安装PC版Qt库
安装XLib库，以保证PC版Qt库能够成功编译
```	sudo apt-get install libX11-dev libXext-dev libXtst-dev	```

解压``qt-everywhere-opensource-src-4.7.4.tar.gz``到 ``/usr/local``目录下，并且重命名``Qt_PC``。

Qt库配置：进入/usr/local/Qt_PC，输入sudo ./config，然后输入`` o ``，之后输入`` yes `` 。
Qt库编译： `` make -j4 ``

#### /usr/bin/ld: 找不到 -lXrender
``` sudo apt-get install libxrender-dev ```


Qt库安装： `` make install ``
安装路径为：`` /usr/local/Trolltech/Qt-4.7.4 ``


<br>
<hr>
<hr>
<br>

## 安装ARM版Qt库
解压``qt-everywhere-opensource-src-4.7.4.tar.gz``到 ``/usr/local``目录下，并且重命名``Qt_ARM``。
Qt库配置：进入/usr/local/Qt_ARM，然后运行一下命令，之后输入``yes``
``` ./configure -prefix /usr/local/Trolltech/QtEmbedded-4.7.4-arm -opensource -embedded arm -xplatform qws/linux-arm-gnueabi-g++ -webkit -qt-gfx-transformed -qt-libtiff -qt-libmng -no-mouse-tslib -qt-mouse-pc -no-mouse-linuxtp -qt-mouse-linuxinput -no-neon -qt-libjpeg -qt-libpng ```

``-prefix /usr/local/Trolltech/QtEmbedded-4.7.4-arm``：表示ARM版Qt4.7.4最终的安装路径是``/usr/local/Trolltech/QtEmbedded-4.7.4-arm``
``-embedded arm``：表示将编译针对ARM平台的embedded版本。
``-xplatform qws/linux-arm-gnueabi-g++``：表示使用linux-arm-gnueabi-g++交叉编译器进行编译。

#### 在这里编译器报错：
    The target system byte order could not be detected!Turn on verbose messaging (-v) to see the final report.You can use the -little-endian or -big-endian switch to
    ./configure to continue.

Qt库配置选项加上```-little-endian``

Qt库编译： `` make -j4 ``
#### 修改交叉编译工具编译Qt库
[http://blog.csdn.net/tyshtang/article/details/42585433](http://blog.csdn.net/tyshtang/article/details/42585433)

Qt库安装： `` make install ``
安装路径为：`` /usr/local/Trolltech/QtEmbedded-4.7.4-arm ``

<br>
<hr>
<hr>
<br>


## 安装交叉编译工具
``` export PATH=/usr/local/external-toolchain/bin:$PATH ```

## arm-none-linux-gnueabi-gcc: 没有那个文件或目录
``` sudo apt-get install lsb-core ```


##
```
export PATH=/opt/external-toolchain/qt4.7.4/bin:$PATH
export PATH=/opt/external-toolchain/qt4.7.4/include:$PATH
export QTDIR=/opt/external-toolchain/qt4.7.4

sudo ln -s /opt/external-toolchain/qt4.7.4/bin/qmake /usr/lib/x86_64-linux-gnu/qt4/bin/qmake
```