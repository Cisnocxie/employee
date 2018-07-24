package com.oocl.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(0,"小明", 20, "男"),
            new Employee(1,"小红", 19, "女"),
            new Employee(2,"小智", 15, "男"),
            new Employee(3,"小刚", 16, "男"),
            new Employee(4,"小霞", 15, "女")));

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
