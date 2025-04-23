package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImplemented;
import com.challenge.api.model.EmployeeStorage;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeStorage employeeStorage;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * Default constructor that the Post Construct will use (see EmployeeStorage.java for more info)
     */
    public EmployeeController(EmployeeStorage employeeStorage) {
        this.employeeStorage = employeeStorage;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("GET /api/v1/employee - Returning all employees");
        return employeeStorage.getEmployees();
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    @GetMapping("/{id}")
    public Employee getEmployeeByUuid(@PathVariable("id") UUID uuid) {
        logger.info("GET /api/v1/employee/{} - Fetching employee by UUID", uuid);
        Employee employee = employeeStorage.getEmployee(uuid);
        if (employee == null) {
            logger.warn("GET /api/v1/employee/{} - Employee not found", uuid);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee found");
        }
        return employee;
    }

    /**
     * @param employee that needs to be added to storage.
     * @return Newly created Employee
     */
    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeImplemented employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            logger.warn("POST /api/v1/employee - First or Last name are empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "First name and last name cannot be empty");
        }
        if (employee.getEmail() == null) {
            logger.warn("POST /api/v1/employee - Email is empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email must exist");
        }
        if (employee.getSalary() == null) {
            logger.warn("POST /api/v1/employee - Salary is empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salary must exist");
        }
        if (employee.getAge() == null) {
            logger.warn("POST /api/v1/employee - Age is empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Age must exist");
        }
        if (employee.getJobTitle() == null) {
            logger.warn("POST /api/v1/employee - Job Title is empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Job title must exist");
        }
        if (employee.getContractHireDate() == null) {
            logger.warn("POST /api/v1/employee - Hire Date is empty");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ContractHireDate must exist");
        }
        employeeStorage.addEmployee(employee);
        logger.info(
                "POST /api/v1/employee - Creating new employee: {} {}",
                employee.getFirstName(),
                employee.getLastName());
        return new ResponseEntity<>(employee, HttpStatus.CREATED).getBody();
    }
}
