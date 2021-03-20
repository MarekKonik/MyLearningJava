package com.marekkonik.controller;

import com.marekkonik.dto.WarehouseModuleDto;
import com.marekkonik.entity.Warehouse;
import com.marekkonik.repository.WarehouseRepository;
import com.marekkonik.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class WarehouseController {


    private final WarehouseRepository warehouseRepository;
    private final WarehouseService warehouseService;



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


    @GetMapping("/warehouse_module_data")
    public WarehouseModuleDto getWarehouseModuleData(@RequestParam Optional<String>idWarehouse){


        if (idWarehouse.isPresent()){
            return warehouseService.getWarehouseModuleData(Long.parseLong(idWarehouse.get()));
        }else {
            return warehouseService.getWarehouseModuleData();
        }



    }

}
