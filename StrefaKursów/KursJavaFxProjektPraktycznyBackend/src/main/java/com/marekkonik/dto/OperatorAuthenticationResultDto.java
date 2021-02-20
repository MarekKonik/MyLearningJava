package com.marekkonik.dto;

import com.marekkonik.entity.Operator;
import lombok.Data;

@Data
public class OperatorAuthenticationResultDto {


    private Long idOperator;
    private String firstName;
    private String lastName;
    private Boolean authenticated;

    public static OperatorAuthenticationResultDto creatUnauthenticated(){
        OperatorAuthenticationResultDto dto = new OperatorAuthenticationResultDto();
        dto.setAuthenticated(false);
        return dto;
    }

    public static OperatorAuthenticationResultDto of(Operator operator){
        OperatorAuthenticationResultDto dto = new OperatorAuthenticationResultDto();
        dto.setAuthenticated(true);
        dto.setFirstName(operator.getEmployee().getFirstName());
        dto.setLastName(operator.getEmployee().getLastName());
        dto.setIdOperator(operator.getIdOperator());
        return dto;
    }

}
