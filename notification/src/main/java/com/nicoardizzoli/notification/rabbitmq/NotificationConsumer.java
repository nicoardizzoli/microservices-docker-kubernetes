package com.nicoardizzoli.notification.rabbitmq;

import com.nicoardizzoli.clients.notification.NotificationRequest;
import com.nicoardizzoli.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "notification.queue")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
