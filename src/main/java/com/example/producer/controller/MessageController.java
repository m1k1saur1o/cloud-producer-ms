package com.example.producer.controller;

import com.example.producer.dto.PedidoRequest;
import com.example.producer.service.MessageProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageProducerService messageProducerService;

    public MessageController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @PostMapping("/mensajes")
    public ResponseEntity<String> enviar(@RequestBody PedidoRequest pedido) {
        messageProducerService.enviarMensaje(pedido);
        return ResponseEntity.ok("Pedido enviado: " + pedido.getCliente());
    }
}
