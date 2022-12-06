package com.carrot.backend.notification.NotificationDto;

import com.carrot.backend.notification.domain.NotificationType;
import com.carrot.backend.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequestDto {
    private User receiver;
    private NotificationType notificationType;
    private String content;
    private String url;


}