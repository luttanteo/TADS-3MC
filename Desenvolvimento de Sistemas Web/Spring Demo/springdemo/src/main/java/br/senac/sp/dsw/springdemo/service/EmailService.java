package br.senac.sp.dsw.springdemo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void send(String to, String message) {
        System.out.println("Enviando e-mail para " + to + ": " + message);
    }
}
