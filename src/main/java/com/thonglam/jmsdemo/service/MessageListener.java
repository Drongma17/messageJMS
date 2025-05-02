package com.thonglam.jmsdemo.service;


import com.thonglam.jmsdemo.model.MessagePayload;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "demo.queue")
    public void receiveMessage(MessagePayload payload) {
        System.out.println("Received message: " + payload);
    }
}