# User Registration System

A simple Spring Boot application for user registration and management.

## Features

- Create new users
- Retrieve users by ID or username
- List all users
- Update user information
- Delete users

## Getting Started

### Prerequisites

- Java 17
- Maven 3.6+

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on port 8080.

## API Endpoints

### Create User
```
POST /api/users
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123"
}
```

### Get User by ID
```
GET /api/users/{id}
```

### Get User by Username
```
GET /api/users/username/{username}
```

### Get All Users
```
GET /api/users
```

### Update User
```
PUT /api/users/{id}
Content-Type: application/json

{
  "username": "john_doe_updated",
  "email": "john.updated@example.com",
  "password": "newpassword123"
}
```

### Delete User
```
DELETE /api/users/{id}
```

## Database

This application uses H2 in-memory database for development. The H2 console is available at:
```
http://localhost:8080/h2-console
```

Connection details:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)

## TODO

- Add email validation
- Add password hashing
- Implement authentication
- Add email verification
- Add pagination support
- Add proper error handling
- Add input validation
- Add logging

## Known Issues

- Passwords are stored in plain text (security risk)
- No email format validation
- No duplicate user checking
- Inconsistent API response formats
- Missing proper error handling
- No pagination for user listing

## License

This project is for demonstration purposes.
