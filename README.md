# Online Booking

Учебное веб-приложение на Spring Boot для онлайн-записи на услуги.

Пользователь может выбрать услугу, адрес и дату записи. Администратор может управлять услугами, адресами, пользователями, изображениями и заявками.

## Возможности

- просмотр списка услуг;
- создание онлайн-заявки;
- просмотр статуса заявки;
- управление заявками;
- управление услугами, адресами и пользователями;
- загрузка изображений.

## Технологии

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Thymeleaf
- MariaDB
- Maven
- HTML, CSS

## Настройка базы данных

Приложение использует MariaDB. Перед запуском создайте базу данных:

```sql
CREATE DATABASE booking CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Данные для подключения задаются в `src/main/resources/application.properties`.

Логин и пароль можно передать через переменные окружения:

```powershell
$env:DB_USERNAME="your_username"
$env:DB_PASSWORD="your_password"
```

## Запуск

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Linux / macOS:

```bash
./mvnw spring-boot:run
```

После запуска приложение будет доступно по адресу:

```text
http://localhost:8080
```

## Основные страницы

| URL | Описание |
| --- | --- |
| `/` | Главная страница |
| `/online/{id}` | Форма записи |
| `/status/{id}` | Статус заявки |
| `/booking` | Управление заявками |
| `/items` | Управление услугами |
| `/locations` | Управление адресами |
| `/users` | Управление пользователями |
| `/upload` | Загрузка изображения |
| `/gallery` | Галерея |
