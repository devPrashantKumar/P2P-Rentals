package com.prashant.notifications.microservice.Repositories;

import com.prashant.notifications.microservice.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    public List<Notification> findByUserId(String userId);
}
