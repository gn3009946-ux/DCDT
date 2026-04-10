package com.dcdoctor.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String user, String message) {
        System.out.println("Notification to " + user + ": " + message);
    }
}