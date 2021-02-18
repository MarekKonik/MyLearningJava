package com.marekkonik.controller;

import com.marekkonik.entity.Employee;
import com.marekkonik.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    @DeleteMapping("/employees")
    ResponseEntity deleteEmployee(@RequestBody Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
        return ResponseEntity.ok().build();
    }


}
