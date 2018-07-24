package com.oocl.employee.service;

import com.oocl.employee.bean.Employee;
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

    public boolean postEmployee(Employee employee) {
        return employeeList.add(employee);
    }

    public boolean deleteEmployee(int id) {
        boolean isContain = false;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                isContain = employeeList.remove(employee);
            }
        }
        return isContain;
    }

    public Employee putEmployee(int id, Employee employee) {
        employeeList.set(employeeList.indexOf(employeeList.stream().filter(employee1 -> employee1.getId() == id).findFirst().get()), employee);
        return employee;
    }

    public Employee getEmployee(int id) {
        return employeeList.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }
}
