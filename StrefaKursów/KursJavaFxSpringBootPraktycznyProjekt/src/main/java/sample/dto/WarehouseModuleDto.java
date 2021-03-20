package sample.dto;


import lombok.Data;

import java.util.List;

@Data
public class WarehouseModuleDto {

    private WarehouseDto selectedWarehouse;
    private List<WarehouseDto> warehouseDtoList;
    public List<ItemDto>itemDtoList;

}
