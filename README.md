# Hospital Management System

A Spring Boot application designed to manage core hospital operations including patients, doctors, appointments, and prescriptions. The system follows a modular and layered architecture to ensure scalability, maintainability, and real-world applicability.

---

## Tech Stack

- **Language:** Java 21+  
- **Framework:** Spring Boot 3.3.5  
- **Frontend:** Thymeleaf, HTML5, CSS3  
- **Data Access:** Spring Data JPA (Hibernate)  
- **Database:** MySQL (Production) / H2 (Testing)  
- **Build Tool:** Maven  

---

## Project Structure

The project follows a structured package hierarchy under:

com.hms

### Packages Overview

- **entity**  
  Contains all database entities such as Patient, Physician, Appointment, and Prescribes.

- **repository**  
  Data access layer. All interfaces extend `JpaRepository` and end with `Repository`.

- **service**  
  Business logic layer.  
  - Interfaces end with `Service` (located in base)  
  - Implementations end with `Impl` (located in base.impl)

- **controller**  
  - API Controllers: REST APIs using `@RestController`  
  - View Controllers: Handle Thymeleaf template rendering and UI navigation

- **module**  
  Contains feature-specific business logic for complex workflows such as physician workload and hospital status.

- **exception**  
  Handles custom exceptions (e.g., `ResourceNotFoundException`) and global error handling.

---

## API & Routing Standards

- REST APIs use plural naming conventions (e.g., `/api/physicians/most-busy`)  
- Controllers define root URLs using `@RequestMapping`  
- View routing is handled separately for Thymeleaf-based UI rendering  

### Example Endpoints

POST   /api/patients  
GET    /api/patients/{id}  
POST   /api/appointments  
PUT    /api/appointments/{id}/cancel  
GET    /api/physicians/{id}/patients  
GET    /api/physicians/most-busy  

---

## System Workflow

Client (Browser) → View Controller → Service → Repository → Database → Thymeleaf Template → Client  

### Flow Explanation

1. Client sends request to Controller  
2. View Controller or REST Controller handles request  
3. Service processes business logic  
4. Repository interacts with Database  
5. Data is returned and rendered via Thymeleaf (for UI) or JSON (for APIs)  

---

## Module Breakdown

### 👤 Patient Module
- Manages patient records  
- Stores personal details and medical history  
- Tracks currently admitted patients in real-time  

### 🩺 Doctor (Physician) Module
- Manages doctor profiles  
- Handles specialization and departmental affiliations  
- Identifies the **Most Busy Physician** using appointment aggregation  

### 📅 Appointment & Room Module
- Core module connecting patients and doctors  
- Manages scheduling and interactions  
- Tracks occupied rooms and nurse-on-call schedules  
- Provides paginated dashboard views  

### 📊 Admin Module
- Provides aggregated hospital insights  
- Tracks total patients and active departments  
- Calculates revenue from completed procedures  

### 💊 Prescription Module
- Stores treatment details  
- Links prescriptions to appointments  

---

## Core System Flow

1. A patient is registered in the system  
2. A doctor is added  
3. An appointment is scheduled  
4. A prescription is generated  
5. Hospital status and analytics are updated  

---

## Key Features

- Modular architecture with clean separation of concerns  
- Layered design (Controller → Service → Repository)  
- Dynamic frontend using Thymeleaf  
- Server-side pagination for large datasets  
- Real-time hospital status tracking  
- Global error handling for API and UI layers  

---

## Testing Framework

- **Unit Testing (Mockito):**  
  Tests business logic and DTO mappings using mocked repository layers  

- **Integration Testing (JUnit + MySQL):**  
  Validates JPQL queries with real database data  
  Uses `@Transactional` to maintain clean test state  

---

## Contributors

This project is collaboratively developed by:

- Ayushi  
- Jaladhi  
- Anushka  
- Unnati Bhardwaj  
