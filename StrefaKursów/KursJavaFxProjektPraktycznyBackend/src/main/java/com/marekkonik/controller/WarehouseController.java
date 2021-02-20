package com.marekkonik.controller;

import com.marekkonik.entity.Warehouse;
import com.marekkonik.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WarehouseController {


    private final WarehouseRepository warehouseRepository;



    @PostMapping("/warehouse")
    public Warehouse newWarehouse(@RequestBody Warehouse newWarehouse){
        return warehouseRepository.save(newWarehouse);
    }

    @GetMapping("/warehouse")
    public List<Warehouse>listWarehouse(){
        return warehouseRepository.findAll();
    }


    @DeleteMapping("/warehouse")
    public ResponseEntity deleteWarehouse(@RequestBody Long idWarehouse){
        warehouseRepository.deleteById(idWarehouse);
        return ResponseEntity.ok().build();
    }

}
