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

drop table app_user;

select * from app_user;
create database bike_service;