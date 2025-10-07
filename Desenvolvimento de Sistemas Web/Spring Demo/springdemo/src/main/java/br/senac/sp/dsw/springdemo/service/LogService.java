package br.senac.sp.dsw.springdemo.service;

import org.springframework.stereotype.Service;

@Service
public class LogService {
    public void log(String info) {
        System.out.println("[LOG] " + info);
    }
}
