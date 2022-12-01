package com.carrot.backend.notification.service;

import com.carrot.backend.notification.NotificationDto.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final NotificationService notificationService;

    @TransactionalEventListener
    @Async
    public void handleNotification(NotificationDto notificationDto){
        notificationService.send(notificationDto.getUser(), notificationDto.getNotificationType(),notificationDto.getContent(),notificationDto.getUrl());
    }
}
