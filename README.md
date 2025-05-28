Indigo

Indigo is a full Java-based web application designed to simplify operations in kindergartens and early education centers. It includes features like student management, event scheduling, parent communication, and resource control — all wrapped in a clean, intuitive UI based on a detailed Figma design.

✨ Key Features

✅ Role-based user authentication

🧒 Student information and attendance management

🗓 Event scheduling and activity tracking

📢 Messaging and notifications for parents and teachers

📚 Resource and material allocation

📑 Swagger UI for testing and documenting APIs

📊 Admin dashboard (planned)

🎨 Figma Design
Take a deep dive into the UI/UX vision:

🔗 Figma Design – https://www.figma.com/design/egY90HlOAiLF53TaTrkM9W/%D0%B4%D0%B5%D1%82%D1%81%D0%B0%D0%B4?node-id=19-7499&t=9CERIDw8BZIpuzkB-0

🧪 Tech Stack
Layer	Tech
Backend	Java 17, Spring Boot, Spring Data JPA
Frontend	Thymeleaf, HTML5, CSS3, JavaScript
Database	PostgreSQL
API Docs	Swagger UI (Springfox/OpenAPI)
Build Tool	Maven
VCS	Git

📁 Project Structure

Indigo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── abdumalik/
│   │   │       └── dev/
│   │   │           └── indigo/
│   │   │               ├── controller/
│   │   │               ├── dto/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── security/
│   │   │               ├── service/
│   │   │               └── IndigoApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
├── pom.xml
└── README.md


⚙️ Getting Started
Prerequisites
Java 17+

Maven 3.8+

PostgreSQL 12+

Internet connection for Maven dependencies

🧰 Setup Instructions

Clone the Repository

git clone https://github.com/Abdumalik-Java/Indigo.git
cd Indigo
Configure PostgreSQL

Create a database:

CREATE DATABASE indigo;
Update src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/indigo
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=create

Run the Application

mvn spring-boot:run
Access

Main app: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui.html

🧪 Testing

mvn test
Unit tests and service layer tests are under development.

🧾 API Documentation

With Swagger UI integrated, all RESTful endpoints are auto-documented and testable at:

👉 http://localhost:8080/swagger-ui.html

📌 Roadmap

 Backend CRUD endpoints

 Swagger integration

 Role-based access control (RBAC)

 Full admin panel

 Responsive UI with Tailwind or Bootstrap

 Email/notification system

👨‍💻 Abdumalik Baxtiyorov - Abdumalik-Java

📄 License
This project is licensed under the MIT License. See the LICENSE file for more info.
