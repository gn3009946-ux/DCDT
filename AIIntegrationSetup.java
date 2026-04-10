package com.dcdoctor.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String generateAnswer(String question) {

        question = question.toLowerCase();

        if(question.contains("diet")) {
            return "Diabetic patients should follow a balanced diet.";
        }

        if(question.contains("sugar")) {
            return "Patients should control sugar intake.";
        }

        return "AI cannot answer";
    }
}