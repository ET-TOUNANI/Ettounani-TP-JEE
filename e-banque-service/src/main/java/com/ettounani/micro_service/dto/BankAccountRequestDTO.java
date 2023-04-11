package com.ettounani.micro_service.dto;

import com.ettounani.micro_service.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private String id;
    private Date createDate;
    private Double balance;
    private String currency;
    private TypeCompte type;
}
