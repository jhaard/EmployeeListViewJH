package com.example.employeelistviewjh;

import java.util.ArrayList;
import java.util.LinkedList;

public class EmployeeDataManager {

    public static ArrayList<Employee> employees = new ArrayList<>();

    public static LinkedList<Integer> idNumbers = new LinkedList<>();

    /**
     *
     * @param employeeID id
     * @param name namn
     * @param age ålder
     * @param salary lön
     * @return employee objekt
     */

    public static Employee createEmployee(String employeeID, String name, String age, String salary) {

        Employee employee = new Employee(employeeID, name, age, salary);
        employees.add(employee);

        return employee;
    }

    /**
     *
     * @param e Employee objekt
     */
    public static void deleteEmployee(Employee e) {
        employees.remove(e);
        idNumbers.remove(e);
    }

    /**
     *
     * @return senaste id-nummer i listan
     */
    public static int getLastID() {
        return idNumbers.getLast();
    }
}



