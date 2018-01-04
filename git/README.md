# Git学习笔记

## 设置Beyond Compare 4 为 Git 默认的比较和合并工具
参考：[Beyond Compare 官方的帮助页面。](http://www.scootersoftware.com/support.php?zz=kb_vcs#gitwindows)
命令行下输入运行以条命令即可：

	git config --global diff.tool bc3
	git config --global difftool.bc3.path "c:/Program Files (x86)/Beyond Compare 4/bcomp.exe"


	git config --global merge.tool bc3
	git config --global mergetool.bc3.path "c:/Program Files (x86)/Beyond Compare 4/bcomp.exe"

<br />

## 添加远程仓库
首先在远程Git服务器上（Github或码云）创建空仓库，然后将已有的本地仓库与之关联，最后把本地仓库的内容推送到远程仓库。
在服务器上创建仓库后会为项目生成一个SSH连接地址：git@服务器域名地址:用户名/项目名.git

	$ git remote add origin git@gitee.com:dezhihuang/git.git
	$ git push -u origin master

把本地库的内容推送到远程，用git push命令，实际上是把当前分支master推送到远程。由于远程库是空的，我们第一次推送master分支时，加上了-u参数，Git不但会把本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来，在以后的推送或者拉取时就可以简化命令。推送成功后，可以立刻在远程Git服务器页面中看到远程库的内容和本地一模一样。从现在起，只要本地作了提交，就可以通过以下命令将本地提交推送至远程服务器：
	
	$ git push origin master


<br />

## 查看远程仓库信息
用git remote -v查看远程库信息：

	$ git remote -v
	origin  git@gitee.com:用户名/项目名.git (fetch)
	origin  git@gitee.com:用户名/项目名.git (push)


<br />

## 删除远程仓库
删除已有的远程仓库（origin表示远程仓库名）：

	$ git remote rm origin 

<br />

## 从远程仓库克隆
现在，假设我们从零开发，那么最好的方式是先创建远程库，然后，从远程库克隆。在Git服务器上创建仓库，获得SSH连接地址，然后克隆到本地。

	$ git clone git@gitee.com:dezhihuang/test.git

在本地仓库修改、提交后，使用以下命令推送至远程服务器：

	$ git push master

<br />

## 关联多个远程仓库
只是远程仓库名、远程仓库SSH连接地址不一样，其它操作都一样：

	$ git remote add gitee git@gitee.com:dezhihuang/git.git
	$ git remote add github git@github.com:dezhihuang/git.git
	$ git push -u gitee master
	$ git push -u github master

可以用``git remote -v``查看远程库信息。

## Git在线教程

https://git.oschina.net/progit/

https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/

https://learngitbranching.js.org/?demo

http://www.yiibai.com/git/

<br />


## 工作区和暂存区
https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/0013745374151782eb658c5a5ca454eaa451661275886c6000 