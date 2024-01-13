package com.example.employeelistviewjh;


/**
 * Employee model
 */
public class Employee {
        private String employeeID;
        private String name;
        private String age;
        private String salary;

    public Employee(String employeeID, String name, String age, String salary) {
            this.employeeID = employeeID;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return  "ID: " + employeeID + "  |  " +
                "Name: " + name + "  |  " +
                "Age: " + age + "  |  " +
                "Salary: " + salary;
    }
}




