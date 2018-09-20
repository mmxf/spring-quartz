package com.mfe.server;

import com.google.common.collect.Queues;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartServer extends AbstractStartServer {
    private final static String SPRING_CONFIG_PATH = "classpath:spring-quartz.xml";
    @Override
    protected void doStart() {
        try {
            final ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doStop() {

    }
    public static void main(String[] args) throws InterruptedException {
        new StartServer().startServer();
        Queues.newLinkedBlockingQueue().take();//需要阻塞，否则会程序退出
    }
}
