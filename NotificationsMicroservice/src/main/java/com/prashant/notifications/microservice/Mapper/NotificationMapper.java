package com.prashant.notifications.microservice.Mapper;

import com.prashant.notifications.microservice.DTOs.NotificationDto;
import com.prashant.notifications.microservice.Entities.Notification;

import java.util.Objects;
import java.util.UUID;

public class NotificationMapper {
    public static Notification mapNotificationDtoToNotification(NotificationDto notificationDto){
        Notification notification = new Notification();
        if(Objects.nonNull(notificationDto.getId())){
            notification.setId(UUID.fromString(notificationDto.getId()));
        }
        notification.setUserId(notificationDto.getUserId());
        notification.setMessage(notificationDto.getMessage());
        notification.setCreatedAt(notificationDto.getCreatedAt());
        notification.setCreatedBy(notificationDto.getCreatedBy());
        notification.setUpdatedAt(notificationDto.getUpdatedAt());
        notification.setUpdatedBy(notificationDto.getUpdatedBy());
        return notification;
    }

    public static NotificationDto mapNotificationToNotificationDto(Notification notification){
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(notification.getId().toString());
        notificationDto.setUserId(notification.getUserId());
        notificationDto.setMessage(notification.getMessage());
        notificationDto.setCreatedAt(notification.getCreatedAt());
        notificationDto.setCreatedBy(notification.getCreatedBy());
        notificationDto.setUpdatedAt(notification.getUpdatedAt());
        notificationDto.setUpdatedBy(notification.getUpdatedBy());
        return notificationDto;
    }
}