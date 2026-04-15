package com.hospital.medicalapp.service;

import com.hospital.medicalapp.entity.Message;
import com.hospital.medicalapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        // Tương lai bạn làm mảng Security, đây là nơi bạn sẽ thêm code:
        // 1. Validate dữ liệu đầu vào (chống XSS)
        // 2. Mã hóa nội dung tin nhắn (AES-256) trước khi lưu

        return messageRepository.save(message);
    }
}