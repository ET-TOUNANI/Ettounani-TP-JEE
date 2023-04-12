package com.ettounani.micro_service.service;

import com.ettounani.micro_service.dto.BankAccountRequestDTO;
import com.ettounani.micro_service.dto.BankAccountResponseDTO;
import com.ettounani.micro_service.entities.Compte;
import com.ettounani.micro_service.mappers.AccountMapper;
import com.ettounani.micro_service.repository.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service  @Transactional @AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private CompteRepository compteRepository;
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        bankAccountDTO.setId(UUID.randomUUID().toString());
        Compte savedAcc = compteRepository.save(accountMapper.fromRequestDTO(bankAccountDTO));
        return accountMapper.fromBankAccount(savedAcc);
    }

    @Override
    public List<BankAccountResponseDTO> findAll() {
        return (List<BankAccountResponseDTO>) compteRepository.findAll().stream().map(t -> accountMapper.fromBankAccount(t));
    }

    @Override
    public BankAccountResponseDTO findById(String id) {
        Compte c = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("count not found"));
        return accountMapper.fromBankAccount(c);
    }

    @Override
    public void deleteById(String id) {
        compteRepository.deleteById(id);
    }

    @Override
    public BankAccountResponseDTO updateCompte(String id, Compte compte) {
        Compte compte1 = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (compte.getBalance() != null) compte1.setBalance(compte.getBalance());
        if (compte.getCurrency() != null) compte1.setCurrency(compte.getCurrency());
        if (compte.getCreateDate() != null) compte1.setCreateDate(compte.getCreateDate());
        if (compte.getType() != null) compte1.setType(compte.getType());
        return accountMapper.fromBankAccount(compteRepository.save(compte1));
    }

}
