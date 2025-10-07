package br.senac.sp.dsw.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationManager {
    private final EmailService emailService;
    private final LogService logService;

//    public NotificationManager(EmailService emailService, LogService logService) {
//        this.emailService = emailService;
//        this.logService = logService;
//    }

    public void notify(String user, String msg) {
        logService.log("Notificando " + user);
        emailService.send(user, msg);
    }
}
