## Reliaquest Entry-Level Java Coding Challenge

**Disclaimer**: This README_SOLUTION.md file was drafted using AI and verified for accuracy by Pranav Bhargava. All code in this project was  written by Pranav Bhargava.

### Overview

This solution implements a simple **Employee Management API** in Java using **Spring Boot**. It creates 3 RESTful endpoints for interacting with employee data and mocking a database using in-memory storage.

---

### File Structure

```
src/
├── com.challenge.api.controller/
│   └── EmployeeController.java         # REST Controller handling API endpoints
├── com.challenge.api.model/
│   ├── Employee.java                   # Interface defining the Employee contract
│   ├── EmployeeImplemented.java        # Concrete class implementing the Employee interface
│   └── EmployeeStorage.java            # Mock database storing employee records
```

---

### Technologies Used

- Java 21
- Spring Boot

---

### Features Implemented

#### 1. **Three API Endpoints**

| Method | Endpoint                     | Description                             |
|--------|------------------------------|-----------------------------------------|
| GET    | `/api/v1/employee`           | Retrieves all employee records          |
| GET    | `/api/v1/employee/{id}`      | Retrieves a specific employee by UUID   |
| POST   | `/api/v1/employee`           | Creates a new employee record           |

---

### Data Model

The `Employee` data model is defined using an interface and a concrete class:

- `Employee.java`: Interface that defines the structure and methods required for any Employee object.
- `EmployeeImplemented.java`: Concrete class implementing the `Employee` interface and containing all necessary fields and logic for getter/setter access.

Fields include:
- UUID
- First name / Last name / Full name
- Email
- Age
- Salary
- Job title
- Contract hire date
- Contract termination date

---

### Mock Database

- `EmployeeStorage.java` mocks a database using a `HashMap<UUID, Employee>`.
- It includes a `@PostConstruct` method that populates the in-memory store with **3 sample employees** on startup.
- Methods for adding and retrieving employees are also made here.

---

### API Endpoint Examples

**GET /api/v1/employee**

Returns all stored employees:
```json
[
  {
    "uuid": "f2345f...",
    "firstName": "Theresa",
    ...
  },
  ...
]
```

**GET /api/v1/employee/{uuid}**

Returns a specific employee by UUID:
```json
{
  "uuid": "f2345f...",
  "firstName": "Theresa",
  ...
}
```

**POST /api/v1/employee**

Creates a new employee record:
```json
{
   "firstName": "Avery",
   "lastName": "Johnson",
   "fullName": "Avery Johnson",
   "email": "avery.johnson@example.com",
   "salary": 85000,
   "age": 32,
   "jobTitle": "Software Engineer",
   "contractHireDate": "2021-06-15T08:30:00Z",
   "contractTerminationDate": null
}
```

Returns: `201 Created` with the created employee.

---

### Input Validation

The `POST` request includes validation to ensure:
- First and last name are not null
- Email, age, salary, job title, and contract hire date are required

---

### Mock Data

Sample employees:
- Theresa Robertson (Software Engineer)
- Leonard Wallace (Data Analyst)
- Eric Hamilton (Project Manager)

Each also has like UUIDs, hire dates, and salaries.

### Run Instructions

1. Make sure **Git** and **JDK 21+** are installed.
2. Clone the project:
   ```bash
   git clone https://github.com/pranavb05/reliaquest-entry-coding-challenege.git
   ```
3. Open the project in your IDE and run the Spring Boot application.

### Logging & Error Handling

Each endpoint includes SLF4J-based `logger.info` statements to log which routes are being hit.
If a UUID does not correspond to any employee, a `404 Not Found` response is returned using `ResponseStatusException`.
This ensures that the API is transparent and robust in edge-case scenarios.

---

### Author

Pranav Bhargava
