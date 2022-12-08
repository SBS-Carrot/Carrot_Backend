package com.carrot.backend.notification.dao;

import com.carrot.backend.notification.domain.Notification;
import com.carrot.backend.notification.domain.NotificationType;
import com.carrot.backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query("select n from Notification n where n.user.id = :userId order by n.id desc")
    List<Notification> findAllByUser(@Param("userId") String userId);

    @Query("select count(n) from Notification n where n.user.id = :userId and n.isRead = false")
    Long countUnReadNotifications(@Param("userId") String userId);

    Optional<Notification> findByNotificationTypeAndUser(NotificationType notificationType, User user);
    Optional<Notification> findById(Long NotificationsId);

    void deleteAllByUser(String userId);
    void deleteById(Long notificationId);

}
