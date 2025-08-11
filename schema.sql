create database user_service;
create database bike_service;
create database payment_service;
create database booking_service;
create database notification_service;

create table app_user (
    id uuid not null,
    email varchar(100) not null,
    name varchar(50) not null,
    phone varchar(10) not null,
    is_active boolean,
    created_at timestamp(6),
    created_by varchar(255),
    updated_at timestamp(6),
    updated_by varchar(255),
    primary key (id)
);

create table app_bike (
    id uuid not null,
    owner_id uuid not null,
    bike_type varchar(255) not null check (bike_type in ('ROAD','MOUNTAIN','HYBRID','ELECTRIC')),
    brand varchar(10) not null,
    hourly_rate float4,
    is_available boolean not null,
    model varchar(100) not null,
    name varchar(50) not null,
    created_at timestamp(6),
    created_by varchar(255),
    updated_at timestamp(6),
    updated_by varchar(255),
    is_active boolean,
    primary key (id)
);

create table app_notification (
    id uuid not null,
    user_id varchar(255) not null,
    message varchar(255) not null,
    created_at timestamp(6),
    created_by varchar(255),
    updated_at timestamp(6),
    updated_by varchar(255),
    primary key (id)
);


CREATE TABLE bookings (
    id SERIAL PRIMARY KEY,
    bike_id INT REFERENCES bikes(id) ON DELETE CASCADE,
    renter_id INT REFERENCES users(id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) CHECK (status IN ('PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE payments (
    id SERIAL PRIMARY KEY,
    booking_id INT REFERENCES bookings(id) ON DELETE CASCADE,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50) CHECK (payment_method IN ('CREDIT_CARD', 'PAYPAL', 'STRIPE')),
    transaction_id VARCHAR(100) UNIQUE,
    status VARCHAR(20) CHECK (status IN ('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100)
);

CREATE TABLE reviews (
    id SERIAL PRIMARY KEY,
    bike_id INT REFERENCES bikes(id) ON DELETE CASCADE,
    reviewer_id INT REFERENCES users(id) ON DELETE CASCADE,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100)
);

CREATE TABLE notifications (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    message TEXT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100)
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_bikes_owner ON bikes(owner_id);
CREATE INDEX idx_bikes_location ON bikes(location_lat, location_lng);
CREATE INDEX idx_bookings_bike ON bookings(bike_id);
CREATE INDEX idx_bookings_renter ON bookings(renter_id);
CREATE INDEX idx_bookings_dates ON bookings(start_time, end_time);
CREATE INDEX idx_payments_booking ON payments(booking_id);
CREATE INDEX idx_reviews_bike ON reviews(bike_id);
CREATE INDEX idx_reviews_reviewer ON reviews(reviewer_id);
CREATE INDEX idx_notifications_user ON notifications(user_id);
