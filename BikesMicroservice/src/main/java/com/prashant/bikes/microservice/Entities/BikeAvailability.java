package com.prashant.bikes.microservice.Entities;

import com.prashant.bikes.microservice.Enums.BikeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "app_bike_availability")
public class BikeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="bike_id", nullable = false)
    private UUID bikeId;

    @Column(name="available_from", updatable = false)
    private LocalDateTime availableFrom;

    @Column(name="available_to", updatable = false)
    private LocalDateTime availableTo;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name="updated_by")
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.createdBy = this.createdBy == null ? "system" : this.createdBy;
        this.updatedBy = this.updatedBy == null ? "system" : this.updatedBy;
        this.availableFrom = this.getAvailableFrom()==null ? LocalDateTime.now() : this.availableFrom;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = this.updatedBy == null ? "system" : this.updatedBy;
    }
}
