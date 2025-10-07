package br.senac.sp.dsw.springdemo.controller;

import br.senac.sp.dsw.springdemo.service.NotificationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationManager manager;

//    public NotificationController(NotificationManager manager) {
//        this.manager = manager;
//    }

    @PostMapping
    public String notify(@RequestParam String user, @RequestParam String msg) {
        manager.notify(user, msg);
        return "Notificação enviada para " + user;
    }
}
