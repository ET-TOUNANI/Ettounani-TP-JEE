package com.ettounani.micro_service.service;

import com.ettounani.micro_service.dto.BankAccountRequestDTO;
import com.ettounani.micro_service.dto.BankAccountResponseDTO;
import com.ettounani.micro_service.entities.Compte;

import java.util.List;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    List<BankAccountResponseDTO> findAll();

    BankAccountResponseDTO findById(String id);

    void deleteById(String id);

    BankAccountResponseDTO updateCompte(String id, Compte compte);
}
