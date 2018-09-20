package com.mfe.server;

import static java.util.Arrays.asList;

import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ServiceManager;

public abstract class AbstractStartServer extends AbstractService {
    /**
     * 服务开始
     */
    protected void startServer() {
        final ServiceManager manager = new ServiceManager(asList(this));
        ServerListener listener = new ServerListener();
        manager.addListener(listener);
        System.out.println("Starting server...");
        manager.startAsync().awaitHealthy();
        System.out.println("server has started successfully.");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Stopping server...");
                    manager.stopAsync().awaitStopped(10, TimeUnit.SECONDS);
                    System.out.println("server has stopped successfully.");
                } catch (Exception timeout) {
                    System.out.println(timeout.getMessage()+"\t"+timeout);
                }
            }
        }));
    }
}
