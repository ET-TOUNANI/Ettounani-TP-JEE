package com.ettounani.micro_service.mappers;

import com.ettounani.micro_service.dto.BankAccountRequestDTO;
import com.ettounani.micro_service.dto.BankAccountResponseDTO;
import com.ettounani.micro_service.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(Compte compte) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(compte, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public Compte fromRequestDTO(BankAccountRequestDTO bankAccountRequestDTO) {
        Compte compte = new Compte();
        BeanUtils.copyProperties(bankAccountRequestDTO, compte);
        return compte;
    }
}
