package com.mfe.server;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;

public class ServerListener extends ServiceManager.Listener {
    @Override
    public void healthy() {
        System.out.println("healthy");
    }

    @Override
    public void stopped() {
        System.out.println("stopped");
    }

    @Override
    public void failure(Service service) {
        System.out.println("failure");
    }
}
