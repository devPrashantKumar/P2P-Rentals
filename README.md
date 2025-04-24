# P2P-Rentals

### Docker commands:
#### run database container
- docker run --name postgres-db -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=user_service -p 5432:5432 -d postgres:16
