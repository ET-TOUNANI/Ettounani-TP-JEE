package com.ettounani.micro_service.dto;

import com.ettounani.micro_service.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private Double balance;
    private String currency;
    private TypeCompte type;
}
