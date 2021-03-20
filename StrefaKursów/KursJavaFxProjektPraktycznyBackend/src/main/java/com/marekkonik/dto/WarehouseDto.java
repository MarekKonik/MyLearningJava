package com.marekkonik.dto;

import com.marekkonik.entity.Warehouse;
import lombok.Data;

@Data
public class WarehouseDto {
    private Long idWarehouse;
    private String name;

    public static WarehouseDto of(Warehouse warehouse) {
        WarehouseDto dto = new WarehouseDto();
        dto.setIdWarehouse(warehouse.getIdWarehouse());
        dto.setName(warehouse.getName());
        return dto;

    }

}
