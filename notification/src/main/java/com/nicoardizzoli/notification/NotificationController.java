package com.nicoardizzoli.notification;

import com.nicoardizzoli.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {


    private final NotificationService notificationService;

    @PostMapping("/send")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.sendNotification(notificationRequest);
    }
}
