# ZooKeeperStart

## 系统环境
- jdk版本：jdk1.8
- zookeeper版本： 3.4.11
- 操作系统版本：Ubuntu 5.4.0

## zookeeper常见知识
- 权限
 create:创建子节点
 read：获取节点/子节点
 write:设置节点数据
 delete：删除子节点
 admin：设置权限
- 打开zk的客户端
./zkCli.sh
断开： ctrl + c
- digest & auth & 超级管理员
- 查看启动的状态
zkServer.sh status
- 启动日志
./zkServer.sh start-foreground

## 常用的Linux命令
- 附文件的权限
chmod a+xwr (具体目录)
- 删除目录及下面文件
rm -rf 非空文件夹名