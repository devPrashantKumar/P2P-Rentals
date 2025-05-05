package com.prashant.notifications.microservice.Services;

import com.prashant.notifications.microservice.DTOs.ResponseDto;
import com.prashant.notifications.microservice.DTOs.NotificationDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface INotificationService {

    public ResponseEntity<ResponseDto> notification(String id);

    public ResponseEntity<ResponseDto> allNotifications();

    public ResponseEntity<ResponseDto> allNotificationsOfUser(String userId);

    public ResponseEntity<ResponseDto> addNotification(NotificationDto notificationDto);

    public ResponseEntity<ResponseDto> updateNotification(String id, NotificationDto notificationDto);
}
