## Технологии

- Java 17
- Maven
- Spring Boot 3.5.
- PostgreSQL
- Mapstruct, Lombok
- Docker
- OpenApi

## Запуск API

### 1. Клонируйте репозиторий
```bash
   git clone https://github.com/helloWoor1d/vet-clinic.git
   cd vet-clinic
```

### 2. Соберите проект
   ```bash
   mvn clean install
   ```

### 3. Запустите проект с docker compose:
   ```bash
   docker-compose up --build
   ```

## После запуска:

- OpenApi: http://localhost:8085/swagger-ui/index.html

- БД (PostgreSQL): localhost:5435
    - user: mira
    - password: password
    - db: vet_clinic