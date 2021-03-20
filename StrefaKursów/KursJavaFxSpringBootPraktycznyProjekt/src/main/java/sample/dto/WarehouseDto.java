package sample.dto;

import lombok.Data;

@Data
public class WarehouseDto {

    private Long idWarehouse;
    public String name;


    @Override
    public String toString(){
        return name;
    }

}
