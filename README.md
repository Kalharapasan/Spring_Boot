"# Spring Boot Projects Repository

This repository contains multiple Spring Boot projects demonstrating various concepts and implementations. All projects are built with Spring Boot 3.5.5 and Java 17.

## 📁 Projects Overview

### 1. CRUD-Operation
A Spring Boot application demonstrating CRUD (Create, Read, Update, Delete) operations.

- **Group ID**: `com.CRUD_Operation`
- **Artifact ID**: `CRUD-Operation`
- **Description**: Demo project for Spring Boot CRUD operations
- **Java Version**: 17
- **Spring Boot Version**: 3.5.5

### 2. Demo
A basic Spring Boot starter application.

- **Group ID**: `com.example`
- **Artifact ID**: `demo`
- **Description**: Demo project for Spring Boot
- **Java Version**: 17
- **Spring Boot Version**: 3.5.5

### 3. Demo1 (Employee Management)
A Spring Boot REST API for employee management with RESTful endpoints.

- **Group ID**: `com.pasan`
- **Artifact ID**: `demo1`
- **Description**: Employee management REST API
- **Java Version**: 17
- **Spring Boot Version**: 3.5.5
- **Features**:
  - Employee entity with fields: id, first name, last name, email, phone, address
  - REST controller with employee endpoints
  - GET API at `/api/employee/` returning employee data

### 4. MySql_Connection
A Spring Boot application demonstrating MySQL database connectivity.

- **Group ID**: `com.pasan`
- **Artifact ID**: `MySql_Connection`
- **Description**: MySQL database connection demonstration
- **Java Version**: 17
- **Spring Boot Version**: 3.5.5

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- MySQL (for MySql_Connection project)

### Running the Applications

#### Option 1: Using Maven Wrapper (Recommended)
```bash
# Navigate to any project directory
cd [project-name]

# On Windows
./mvnw.cmd spring-boot:run

# On Unix/Linux/Mac
./mvnw spring-boot:run
```

#### Option 2: Using Maven
```bash
# Navigate to any project directory
cd [project-name]

# Run the application
mvn spring-boot:run
```

#### Option 3: Running the JAR
```bash
# Build the project
mvn clean package

# Run the generated JAR
java -jar target/[artifact-id]-0.0.1-SNAPSHOT.jar
```

## 📡 API Endpoints

### Demo1 (Employee Management)
- **GET** `/api/employee/` - Retrieve employee list
  - Returns a sample employee with personal details

## 🛠️ Technologies Used

- **Framework**: Spring Boot 3.5.5
- **Language**: Java 17
- **Build Tool**: Maven
- **Database**: MySQL (for MySql_Connection project)
- **Architecture**: REST API, MVC Pattern

## 📂 Project Structure

Each project follows the standard Maven directory structure:
```
project-name/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── target/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── HELP.md
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is for educational and demonstration purposes.

## 👤 Author

**Kalhara Pasan**
- GitHub: [@Kalharapasan](https://github.com/Kalharapasan)

## 📞 Support

If you have any questions or need help with these projects, feel free to reach out or create an issue in this repository.

---

*Last updated: September 29, 2025*" 
