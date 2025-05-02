package com.thonglam.jmsdemo.service;


import com.thonglam.jmsdemo.model.MessagePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    private final String queueName = "demo.queue";

    public void sendMessage(MessagePayload payload) {
        jmsTemplate.convertAndSend(queueName, payload);
    }
}