package com.nicoardizzoli.notification;

import com.nicoardizzoli.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setToCustomerId(notificationRequest.toCustomerId());
        notification.setToCustomerEmail(notificationRequest.toCustomerEmail());
        notification.setSender("sender");
        notification.setMessage(notificationRequest.message());
        notification.setSentAt(LocalDateTime.now());

        notificationRepository.save(notification);


    }
}
