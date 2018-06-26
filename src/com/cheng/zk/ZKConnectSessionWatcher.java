package com.cheng.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Author :cheng
 * @Description:
 * @Date: created in 15:44 2018/6/26
 * @Reference:
 */
public class ZKConnectSessionWatcher implements Watcher{
    final static Logger logger = LoggerFactory.getLogger(ZKConnectSessionWatcher.class);
    public static final String zkServerPath = "192.168.1.106:2181";
    public static final Integer timeout = 5000;

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(zkServerPath, timeout, new ZKConnectSessionWatcher());
        long sessionId = zk.getSessionId();
        String ssid = "0x" + Long.toHexString(sessionId);
        logger.info(ssid);

        byte[] sessionPassword = zk.getSessionPasswd();
        logger.warn("客户端开始连接zookeeper服务器...");
        logger.warn("连接状态：{}", zk.getState());
        new Thread().sleep(1000);
        logger.warn("连接状态：{}", zk.getState());

        new  Thread().sleep(200);

        // 开始会话重连
        logger.warn("开始会话重连...");

        ZooKeeper zkSession = new ZooKeeper(zkServerPath, timeout, new ZKConnectSessionWatcher(),sessionId, sessionPassword);
        logger.warn("重新连接状态zkSession：{}", zkSession.getState());
        new Thread().sleep(1000);
        logger.warn("重新连接状态zkSession：{}", zkSession.getState());

    }
    @Override
    public void process(WatchedEvent event) {
        logger.warn("接受到watch通知：{}", event);
    }
}