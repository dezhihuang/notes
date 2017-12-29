# Git学习笔记

## 设置Beyond Compare 4 为 Git 默认的比较和合并工具
参考：[Beyond Compare 官方的帮助页面。](http://www.scootersoftware.com/support.php?zz=kb_vcs#gitwindows)
命令行下输入运行以条命令即可：

	git config --global diff.tool bc3
	git config --global difftool.bc3.path "c:/Program Files (x86)/Beyond Compare 4/bcomp.exe"


	git config --global merge.tool bc3
	git config --global mergetool.bc3.path "c:/Program Files (x86)/Beyond Compare 4/bcomp.exe"




<br />


## Git在线教程

https://git.oschina.net/progit/

https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/

https://learngitbranching.js.org/?demo

http://www.yiibai.com/git/

<br />


## 工作区和暂存区
https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/0013745374151782eb658c5a5ca454eaa451661275886c6000 