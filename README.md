#  Hospital Management System

A Spring Boot application designed to manage core hospital operations including patients, doctors, appointments, and prescriptions. The system follows a modular and layered architecture to ensure scalability, maintainability, and real-world applicability.

---

##  Tech Stack

- **Language:** Java 21+  
- **Framework:** Spring Boot  
- **Data Access:** Spring Data JPA (Hibernate)  
- **Database:** MySQL  
- **Build Tool:** Maven  

---

##  Project Structure

The project follows a structured package hierarchy under:

com.hms

###  Packages Overview

- **entity**  
  Contains all database entities such as Patient, Physician, Appointment, and Prescribes.

- **repository**  
  Data access layer. All interfaces extend `JpaRepository` and end with `Repository`.

- **service**  
  Business logic layer.  
  - Interfaces end with `Service`  
  - Implementations end with `Impl`

- **controller**  
  REST APIs for handling client requests.  
  All classes use `@RestController`.

- **module**  
  Contains feature-specific business logic (e.g., physician module, prescription module).

- **exception**  
  Handles custom exceptions and global error handling.

---

##  API & Routing Standards

- All controllers use `@RestController`  
- Base URL uses plural naming  
- Each controller defines a root URL with `@RequestMapping`  

###  Example Endpoints

POST   /patients/  
GET    /patients/{id}  
POST   /appointments/  
PUT    /appointments/{id}/cancel  
GET    /physicians/{id}/patients  

---

##  System Workflow

Client → Controller → Service → Repository → Database  

### Flow Explanation

1. Client sends request to Controller  
2. Controller calls Service  
3. Service processes business logic  
4. Repository interacts with Database  
5. Response is returned to client  

---

##  Module Breakdown

### 👤 Patient Module
- Manages patient records  
- Stores personal details and medical history  

###  Doctor (Physician) Module
- Manages doctor profiles  
- Handles specialization and certifications  

###  Appointment Module
- Core module of the system  
- Connects patients and doctors  
- Manages scheduling and interactions  

###  Prescription Module
- Stores treatment details  
- Links prescriptions to appointments  

---

##  Core System Flow

1. A patient is registered in the system  
2. A doctor is added  
3. An appointment is scheduled between patient and doctor  
4. A prescription is created for that appointment  

---

##  Key Features

- Modular architecture  
- Layered design (Controller → Service → Repository)  
- Real-world hospital workflow implementation  
- Clean separation of concerns  

---

##  Future Enhancements

- Frontend integration (Thymeleaf / React)  
- Authentication & Authorization  
- Dashboard analytics  
- Reporting system  

---

##  Contribution Workflow

1. Create a feature branch  
2. Make changes  
3. Commit with meaningful messages  
4. Push to branch  
5. Create Pull Request  
6. Merge after review  

---

##  Contributors

This project is collaboratively developed by:

- Ayushi  
- Jaladhi  
- Anushka  
- Unnati  

---

## Status

- Core modules implemented  
- Backend APIs functional  
- Modular structure established  
