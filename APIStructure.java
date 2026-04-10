package com.dcdoctor.controller;

import com.dcdoctor.service.AIService;
import com.dcdoctor.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final AIService aiService;
    private final NotificationService notificationService;

    public ChatController(AIService aiService, NotificationService notificationService) {
        this.aiService = aiService;
        this.notificationService = notificationService;
    }

    @PostMapping
    public String askQuestion(@RequestBody String question) {

        String answer = aiService.generateAnswer(question);

        if(answer.equals("AI cannot answer")) {
            notificationService.sendNotification("doctor", "New patient question");
        }

        return answer;
    }
}