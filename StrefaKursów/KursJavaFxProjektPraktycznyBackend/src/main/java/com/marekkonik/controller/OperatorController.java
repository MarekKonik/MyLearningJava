package com.marekkonik.controller;

import com.marekkonik.entity.Operator;
import com.marekkonik.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorRepository operatorRepository;

    @PostMapping("/operator")
    Operator newOperator(@RequestBody Operator newOprator){
        return operatorRepository.save(newOprator);
    }

    @GetMapping("/operator")
    List<Operator>listOperator(){
        return operatorRepository.findAll();
    }

    @DeleteMapping("/oprator")
    ResponseEntity deleteOperator(@RequestBody Long idOperator){
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

}
