# Club Management System Backend

A robust Spring Boot backend for managing university clubs, users, events, and notifications. This system provides secure RESTful APIs for club creation, user management, event handling, and more, with JWT authentication and Firebase push notifications.

## Features
- Club creation, editing, and management
- User roles: Admin, Manager, Student
- Event management for clubs
- Category and membership management
- JWT-based authentication and authorization
- Firebase push notifications
- MySQL database integration
- Secure environment variable configuration
- RESTful API endpoints

## Tech Stack
- Java 11
- Spring Boot 2.6+
- Spring Security (JWT)
- MySQL
- Firebase Admin SDK
- Maven

## Getting Started

### Prerequisites
- Java 11+
- Maven
- MySQL database

### Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/habeebFayez/CMS_Spring_Backend.git
   cd CMS_Spring_Backend
   ```
2. **Configure environment variables:**
   - Create a `.env` file in the project root with the following variables:
     ```env
     DB_URL=jdbc:mysql://localhost:3306/your_db_name
     DB_USERNAME=your_db_user
     DB_PASSWORD=your_db_password
     JWT_SECRET=your_jwt_secret
     JWT_EXPIRATION=86400000
     FIREBASE_CONFIG_PATH=src/main/resources/your-firebase-adminsdk.json
     ```
   - Ensure `.env` is **not** committed to version control.
3. **Install dependencies:**
   ```sh
   mvn clean install
   ```
4. **Run database migrations** (if any).

### Running the Application
```sh
mvn spring-boot:run
```
The server will start on `http://localhost:8080` by default.

## API Overview
- All endpoints are prefixed with `/api/`
- JWT authentication is required for protected routes
- Example endpoints:
  - `POST /api/club/createClub` — Create a new club
  - `PUT /api/club/editClub` — Edit club details
  - `GET /api/club/getAllClubs` — List all clubs
  - `POST /api/auth/login` — User login

## Environment Variables
Sensitive configuration is managed via environment variables. See `.env.example` for a template.

## Security
- Secrets and credentials are **never** committed to the repository
- `.gitignore` excludes `.env`, Firebase keys, and other sensitive files
- Use strong, unique secrets for JWT and database credentials

## Contribution
Contributions are welcome! Please fork the repo and submit a pull request.

## License
This project is licensed under the MIT License.

## Contact
For questions or support, contact [habeeb.fayez@gmail.com](mailto:habeeb.fayez@gmail.com) 