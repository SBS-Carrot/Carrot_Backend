package com.carrot.backend.notification.NotificationDto;

import com.carrot.backend.notification.domain.Notification;
import com.carrot.backend.user.domain.User;
import lombok.Data;

@Data
public class NotificationDto {

    private Long id;

    private String content;

    private String url;

    private Boolean isRead;

    private String notificationType;

    private User user;

    public static NotificationDto create(Notification notification){
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(notification.getId());
        notificationDto.setNotificationType(notification.getNotificationType());
        notificationDto.setUser(notification.getUser());
        notificationDto.setContent(notification.getContent());
        notificationDto.setIsRead(notification.getIsRead());
        notificationDto.setUrl(notification.getUrl());
        return notificationDto;


    }
}
