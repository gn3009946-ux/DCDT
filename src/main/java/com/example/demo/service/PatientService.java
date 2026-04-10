package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public String login(String username, String password) {

        Optional<Patient> patient = repo.findByUsername(username);

        if (patient.isPresent() &&
                patient.get().getPassword().equals(password)) {

            return "Login success";
        }

        return "Login failed";
    }

    public Patient register(Patient p) {
        return repo.save(p);
    }
}