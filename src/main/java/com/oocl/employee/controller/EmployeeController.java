package com.oocl.employee.controller;

import com.oocl.employee.service.EmployeeService;
import com.oocl.employee.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee e = null;
        if (employeeService.addEmployee(employee)) {
            e = employee;
        }
        return e;
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}
