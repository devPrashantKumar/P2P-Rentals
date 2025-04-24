# P2P-Rentals

### Docker commands:
- docker run -d --name pgadmin -p 5050:80 -e PGADMIN_DEFAULT_EMAIL=admin@admin.com -e PGADMIN_DEFAULT_PASSWORD=admin dpage/pgadmin4
- docker run --name postgres-db -e POSTGRES_USER=devuser -e POSTGRES_PASSWORD=devpass -e POSTGRES_DB=devdb -p 5432:5432 -d postgres:16
