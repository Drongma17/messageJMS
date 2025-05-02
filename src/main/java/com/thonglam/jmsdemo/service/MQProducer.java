package com.thonglam.jmsdemo.service;

import com.thonglam.jmsdemo.model.MessagePayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MQProducer {

    private final JmsTemplate jmsTemplate;
    @Value("${ibm.mq.queue}")
    private String queue;

    public MQProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(MessagePayload payload) {
        jmsTemplate.convertAndSend(queue, payload);
    }
}