package com.prashant.bikes.microservice.Entities;

import com.prashant.bikes.microservice.Enums.BikeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "app_bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="owner_id", nullable = false)
    private UUID ownerId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String model;

    @Column(nullable = false, length = 10)
    private String brand;

    @Enumerated(value=EnumType.STRING)
    @Column(name="bike_type",nullable = false)
    private BikeType bikeType;

    @Column(name="hourly_rate",precision = 2,length = 6)
    private Double hourlyRate;

    @Column(name="is_available", nullable=false)
    private Boolean isAvailable;

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
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = this.updatedBy == null ? "system" : this.updatedBy;
    }
}
