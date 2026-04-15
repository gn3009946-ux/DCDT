package com.hospital.medicalapp.controller;

import com.hospital.medicalapp.entity.Message;
import com.hospital.medicalapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/group/{roomId}")
    public Message sendMessage(@DestinationVariable String roomId, @Payload Message message) {
        message.setRoomId(roomId);
        // Lưu tin nhắn (dù là gõ tay hay nói bằng miệng) thông qua Service
        return messageService.saveMessage(message);
    }
}