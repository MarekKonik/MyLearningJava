package com.marekkonik.controller;

import com.marekkonik.dto.OperatorAuthenticationResultDto;
import com.marekkonik.dto.OperatorCredentialsDto;
import com.marekkonik.entity.Operator;
import com.marekkonik.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorRepository operatorRepository;

    @PostMapping("/operator")
    public Operator newOperator(@RequestBody Operator newOprator) {
        return operatorRepository.save(newOprator);
    }

    @GetMapping("/operator")
    public List<Operator> listOperator() {
        return operatorRepository.findAll();
    }

    @DeleteMapping("/oprator")
    public ResponseEntity deleteOperator(@RequestBody Long idOperator) {
        operatorRepository.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }


    @PostMapping("verfiy_operator_credentials")
    public OperatorAuthenticationResultDto verifyOperatorCredentials(@RequestBody OperatorCredentialsDto operatorCredentialsDto) {
        Optional<Operator> operationOptional = operatorRepository.findByLogin(operatorCredentialsDto.getLogin());

        if (!operationOptional.isPresent()){
            return OperatorAuthenticationResultDto.creatUnauthenticated();
        }

        Operator operator = operationOptional.get();

        if (!operator.getPassword().equals(operatorCredentialsDto.getPassword())){
            return OperatorAuthenticationResultDto.creatUnauthenticated();
        }else {
            return OperatorAuthenticationResultDto.of(operator);
        }
    }

}
