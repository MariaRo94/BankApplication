package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example");

        OperationConsooleListener consooleListener=context.getBean(OperationConsooleListener.class);
        consooleListener.start();
        consooleListener.listenUpdates();
        consooleListener.end();
    }
}
