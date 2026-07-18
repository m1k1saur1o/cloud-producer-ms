package com.example.producer.service;

import com.example.producer.dto.PedidoRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private static final String QUEUE = "myQueue";

    private final RabbitTemplate rabbitTemplate;

	public MessageProducerService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void enviarMensaje(PedidoRequest pedido) {
		rabbitTemplate.convertAndSend(QUEUE, pedido);
	}
}
