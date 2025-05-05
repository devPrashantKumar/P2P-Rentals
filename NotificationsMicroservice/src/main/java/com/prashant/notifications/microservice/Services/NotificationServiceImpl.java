package com.prashant.notifications.microservice.Services;

import com.prashant.notifications.microservice.Constants.MessageConstant;
import com.prashant.notifications.microservice.DTOs.ResponseDto;
import com.prashant.notifications.microservice.DTOs.NotificationDto;
import com.prashant.notifications.microservice.Entities.Notification;
import com.prashant.notifications.microservice.Mapper.NotificationMapper;
import com.prashant.notifications.microservice.Repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.prashant.notifications.microservice.Constants.MessageConstant.*;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements INotificationService {

    private NotificationRepository notificationRepository;

    public ResponseEntity<ResponseDto> notification(String id) {
        Notification notification = notificationRepository.findById(UUID.fromString(id)).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(NOTIFICATION_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_S,id),notification));
    }

    public ResponseEntity<ResponseDto> allNotifications() {
       List<NotificationDto> notifications = notificationRepository.findAll().stream().map(NotificationMapper::mapNotificationToNotificationDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(NOTIFICATION_DETAILS_FETCHED_SUCCESSFULLY),notifications));
    }

    @Override
    public ResponseEntity<ResponseDto> allNotificationsOfUser(String userId) {
        List<NotificationDto> notifications = notificationRepository.findByUserId(userId).stream().map(NotificationMapper::mapNotificationToNotificationDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(NOTIFICATION_DETAILS_FETCHED_SUCCESSFULLY_FOR_USERID_S,userId),notifications));
    }

    @Override
    public ResponseEntity<ResponseDto> addNotification(NotificationDto notificationDto) {
        Notification notification = NotificationMapper.mapNotificationDtoToNotification(notificationDto);
        notificationRepository.save(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS,notification));
    }

    @Override
    public ResponseEntity<ResponseDto> updateNotification(String id, NotificationDto notificationDto) {
        Notification notification = notificationRepository.findById(UUID.fromString(id)).orElseThrow();

        Optional.ofNullable(notificationDto.getUserId()).ifPresent(notification::setUserId);
        Optional.ofNullable(notificationDto.getMessage()).ifPresent(notification::setMessage);

        notificationRepository.save(notification);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(NOTIFICATION_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_S,id),notification));
    }
}
