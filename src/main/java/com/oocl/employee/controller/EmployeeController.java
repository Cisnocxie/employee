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
    public Employee postEmployee(@RequestBody Employee employee) {
        Employee e = null;
        if (employeeService.postEmployee(employee)) {
            e = employee;
        }
        return e;
    }

    @DeleteMapping("/employees/{id}")
    public Void delete(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return null;
    }

    @PutMapping("/employees/{id}")
    public Employee putEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.putEmployee(id, employee);
        return employee;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }
}
