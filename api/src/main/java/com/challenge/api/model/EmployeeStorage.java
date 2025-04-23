package com.challenge.api.model;

import jakarta.annotation.PostConstruct;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class is designed to mock a database.
 */
@Component
public class EmployeeStorage {
    // Variable to store employees
    private Map<UUID, Employee> employees = new HashMap<>();

    // Variable for Logger
    private final Logger logger = LoggerFactory.getLogger(EmployeeStorage.class);

    // Getter for all employees
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    // Getter for a singular employee given a UUID
    public Employee getEmployee(UUID id) {
        return employees.get(id);
    }

    // Adds a new employee to the storage
    public void addEmployee(Employee employee) {
        employees.put(employee.getUuid(), employee);
    }

    /**
     * Names generated using https://homepage.net/name_generator/
     * This function creates the Mock Data required for this program.
     * This function is run automatically using @PostConstruct when the program is started.
     */
    @PostConstruct
    public void addMockData() {
        Employee e1 = new EmployeeImplemented();
        e1.setUuid(UUID.randomUUID());
        e1.setFirstName("Theresa");
        e1.setLastName("Robertson");
        e1.setFullName("Theresa Robertson");
        e1.setEmail("theresa.robertson@gmail.com");
        e1.setAge(29);
        e1.setSalary(85000);
        e1.setJobTitle("Software Engineer");
        e1.setContractHireDate(Instant.now());
        e1.setContractTerminationDate(null);
        employees.put(e1.getUuid(), e1);

        Employee e2 = new EmployeeImplemented();
        e2.setUuid(UUID.randomUUID());
        e2.setFirstName("Leonard");
        e2.setLastName("Wallace");
        e2.setFullName("Leonard Wallace");
        e2.setEmail("leonard.wallace@gmail.com");
        e2.setAge(35);
        e2.setSalary(95000);
        e2.setJobTitle("Data Analyst");
        e2.setContractHireDate(Instant.now().minusSeconds(31536000));
        e2.setContractTerminationDate(null);
        employees.put(e2.getUuid(), e2);

        Employee e3 = new EmployeeImplemented();
        e3.setUuid(UUID.randomUUID());
        e3.setFirstName("Eric");
        e3.setLastName("Hamilton");
        e3.setFullName("Eric Hamilton");
        e3.setEmail("eric.hamilton@gmail.com");
        e3.setAge(42);
        e3.setSalary(120000);
        e3.setJobTitle("Project Manager");
        e3.setContractHireDate(Instant.now().minusSeconds(63072000));
        e3.setContractTerminationDate(null);
        employees.put(e3.getUuid(), e3);

        logger.info("Added {} employee(s)", employees.size());
    }
}
