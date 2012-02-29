package com.testing.blah;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * {@link Service} funappz base service implementation.
 */
@Component
public class FunappzService implements Service {
	
	@Autowired
	ConnectionFactory connectionFactory;

	public void ConvertAndSend(String queueName, String message) {
		AmqpAdmin admin = new RabbitAdmin(connectionFactory);
		admin.declareQueue(new Queue(queueName));
		
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		template.convertAndSend(queueName, message);
	}

	public Object receiveAndConvert(String queuename) {
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		return template.receiveAndConvert(queuename);
	}
	
}
