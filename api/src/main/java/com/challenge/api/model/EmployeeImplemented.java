package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

public class EmployeeImplemented implements Employee {
    // Declaring all variables required from the Employee Interface file.
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant hireDate;
    private Instant terminationDate;

    // ALL GETTERS AND SETTERS
    @Override
    public UUID getUuid() {
        return id;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.id = uuid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String name) {
        this.firstName = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String name) {
        this.lastName = name;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setFullName(String name) {
        String first = name.substring(0, name.indexOf(" "));
        String last = name.substring(name.indexOf(" ") + 1);
        this.firstName = first;
        this.lastName = last;
    }

    @Override
    public Integer getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Instant getContractHireDate() {
        return hireDate;
    }

    @Override
    public void setContractHireDate(Instant date) {
        this.hireDate = date;
    }

    @Override
    public Instant getContractTerminationDate() {
        return terminationDate;
    }

    @Override
    public void setContractTerminationDate(Instant date) {
        this.terminationDate = date;
    }
}
