drop table app_user;
select * from app_user;

drop table app_notification;
select * from app_notification;

INSERT INTO app_notification (
    id, user_id, message, created_at, created_by, updated_at, updated_by
) VALUES
('9a4b1fc1-8b1e-4b3f-934d-8b2a9d8d07f0', 'user_001', 'Welcome to our platform!', NOW(), 'admin', NOW(), 'admin'),

('b6b0e0e2-c1d3-43fa-85a6-6e34c4f8161d', 'user_002', 'Your profile has been updated.', NOW(), 'system', NOW(), 'system'),

('c7a58e67-716c-44be-9c29-46e63a6c58ff', 'user_001', 'Don’t forget to verify your email.', NOW(), 'admin', NOW(), 'system'),

('d1f9e1d9-f0c3-41c7-b0cc-9349dfe979c6', 'user_003', 'You have a new message.', NOW(), 'support', NOW(), 'support'),

('e2b5d2ae-2dc4-4d98-8919-3d6f94d76f0a', 'user_002', 'Weekly newsletter available now.', NOW(), 'newsletter_bot', NOW(), 'newsletter_bot');

