package com.marekkonik.controller;

import com.marekkonik.entity.QuantityType;
import com.marekkonik.repository.QuantityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuantityTypeController {

    private final QuantityTypeRepository quantityTypeRepository;

    public @PostMapping("/quantity_type")
    QuantityType newQuantityType(@RequestBody QuantityType newQuantityType){
        return quantityTypeRepository.save(newQuantityType);
    }

    @GetMapping("/quantity_type")
    public List<QuantityType> listQuantityType(){
        return quantityTypeRepository.findAll();
    }

@DeleteMapping("/quantity_type")
    public ResponseEntity deleteQuantityType(@RequestBody Long idQuantityType){
        quantityTypeRepository.deleteById(idQuantityType);
        return ResponseEntity.ok().build();
}


}
