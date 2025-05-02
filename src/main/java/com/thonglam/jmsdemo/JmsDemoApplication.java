package com.thonglam.jmsdemo;

import com.thonglam.jmsdemo.model.MessagePayload;
import com.thonglam.jmsdemo.service.MQProducer;
import com.thonglam.jmsdemo.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JmsDemoApplication implements CommandLineRunner {

	@Autowired
	private MessageProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(JmsDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		producer.sendMessage(new MessagePayload("001", "Hello from JMS"));
	}

	@Bean
	public ApplicationRunner runner(MQProducer producer) {
		return args -> {
			MessagePayload payload = new MessagePayload();
			payload.setId("001");
			payload.setContent("Test message to IBM MQ");
			producer.sendMessage(payload);
		};
	}
}