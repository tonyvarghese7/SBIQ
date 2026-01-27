# Quiz App

## How to Run

### 1. Database Configuration
Before running the application, you must configure your database connection.
Open `src/main/resources/application.properties` and update the following lines with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app
spring.datasource.username=YOUR_USERNAME_HERE
spring.datasource.password=YOUR_PASSWORD_HERE
```

Make sure you have created a database named `quiz_app` in your MySQL server locally.

### 2. Running the App
You can run the application using Maven:

```bash
mvn spring-boot:run
```

Or by running the main class `com.example.quiz.QuizApplication` in your IDE.

### 3. Accessing the App
Once running, open your browser to:
http://localhost:8081
