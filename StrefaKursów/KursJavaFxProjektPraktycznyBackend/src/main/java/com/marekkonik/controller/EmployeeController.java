package com.marekkonik.controller;

import com.marekkonik.dto.EmployeeDto;
import com.marekkonik.entity.Employee;
import com.marekkonik.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public EmployeeDto newEmployee(@RequestBody EmployeeDto newEmployee) {

        return EmployeeDto.of(employeeRepository.save(Employee.of(newEmployee)));
    }

    @GetMapping("/employees")
    public List<EmployeeDto> listEmployees()
    {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDto::of)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/employees")
    public ResponseEntity deleteEmployee(@RequestBody Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
        return ResponseEntity.ok().build();
    }


}
