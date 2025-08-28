# Firebase Chat Application

This is a simple chat application built using Java and Spring Boot, integrated with Firebase for authentication, storage, and database functionalities.

## Features

- User registration and login using Firebase Authentication
- Real-time chat functionality
- File storage and retrieval using Firebase Storage
- Message storage and retrieval using Firebase Realtime Database

## Technologies Used

- Java
- Spring Boot
- Firebase (Authentication, Storage, Realtime Database)
- Maven

## Project Structure

```
firebase-chat-java
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── chatapp
│   │   │               ├── Application.java
│   │   │               ├── controllers
│   │   │               │   ├── ChatController.java
│   │   │               │   └── AuthController.java
│   │   │               ├── models
│   │   │               │   ├── Message.java
│   │   │               │   └── User.java
│   │   │               ├── services
│   │   │               │   ├── AuthService.java
│   │   │               │   ├── StorageService.java
│   │   │               │   └── DatabaseService.java
│   │   │               └── firebase
│   │   │                   └── FirebaseConfig.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── chatapp
│                       └── ApplicationTests.java
├── pom.xml
├── .gitignore
└── README.md
```

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd firebase-chat-java
   ```

3. Update the `application.properties` file with your Firebase credentials.

4. Build the project using Maven:
   ```
   mvn clean install
   ```

5. Run the application:
   ```
   mvn spring-boot:run
   ```

## Usage

- Register a new user by sending a POST request to `/auth/register`.
- Log in an existing user by sending a POST request to `/auth/login`.
- Send a message by sending a POST request to `/chat/send`.
- Retrieve messages by sending a GET request to `/chat/messages`.

## Contributing

Feel free to submit issues or pull requests for improvements and bug fixes.