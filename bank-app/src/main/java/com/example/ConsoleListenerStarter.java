package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ConsoleListenerStarter {
    private final OperationConsooleListener operationConsooleListener;
    private Thread consoleListenerThread;

    public ConsoleListenerStarter(OperationConsooleListener operationConsooleListener) {
        this.operationConsooleListener = operationConsooleListener;
    }

    @PostConstruct
    public void postConstruct() {
        consoleListenerThread = new Thread(()->{
                operationConsooleListener.start();
        operationConsooleListener.listenUpdates();});
        consoleListenerThread.start();
    }

    @PreDestroy
    public void preDestroy(){
        consoleListenerThread.interrupt();
        operationConsooleListener.end();
    }
}
