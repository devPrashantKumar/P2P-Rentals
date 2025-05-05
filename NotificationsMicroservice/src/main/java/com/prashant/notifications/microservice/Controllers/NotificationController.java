package com.prashant.notifications.microservice.Controllers;

import com.prashant.notifications.microservice.DTOs.NotificationDto;
import com.prashant.notifications.microservice.DTOs.ResponseDto;
import com.prashant.notifications.microservice.Services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/health-check")
    public String sayHello(){
        return String.format("Hello %s is UP and Running",applicationName);
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<ResponseDto> notification(@PathVariable("id") String id){
        return this.notificationService.notification(id);
    }

    @GetMapping("/notifications")
    public ResponseEntity<ResponseDto> allNotifications(){
        return this.notificationService.allNotifications();
    }

    @GetMapping("/notifications/{id}")
    public ResponseEntity<ResponseDto> allNotificationsOfUser(@PathVariable("id") String userId){
        return this.notificationService.allNotificationsOfUser(userId);
    }

    @PostMapping("/add-notification")
    public ResponseEntity<ResponseDto> addNotification(@RequestBody NotificationDto notificationDto){
        return this.notificationService.addNotification(notificationDto);
    }

    @PutMapping("/update-notification/{id}")
    public ResponseEntity<ResponseDto> updateNotification(@PathVariable("id") String id, @RequestBody NotificationDto notificationDto){
        return this.notificationService.updateNotification(id,notificationDto);
    }
}
