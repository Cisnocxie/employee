package com.oocl.employee.controller;

import com.oocl.employee.service.EmployeeService;
import com.oocl.employee.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee e = null;
        if (employeeService.addEmployee(employee)) {
            e = employee;
        }
        return e;
    }
}
