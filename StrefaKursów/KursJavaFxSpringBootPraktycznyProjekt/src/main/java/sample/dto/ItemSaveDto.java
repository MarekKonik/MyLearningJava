package sample.dto;

import lombok.Data;

@Data
public class ItemSaveDto {
    private String name;
    private Double quantity;
    private long idQuantityType;
    private long idWarehouse;
}
