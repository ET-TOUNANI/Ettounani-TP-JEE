package com.ettounani.micro_service.web;

import com.ettounani.micro_service.dto.BankAccountRequestDTO;
import com.ettounani.micro_service.dto.BankAccountResponseDTO;
import com.ettounani.micro_service.entities.Compte;
import com.ettounani.micro_service.mappers.AccountMapper;
import com.ettounani.micro_service.repository.CompteRepository;
import com.ettounani.micro_service.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class BankServiceControllerGraohql {
    private CompteRepository compteRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    @QueryMapping
    public List<Compte> accountsList(){
        return compteRepository.findAll();
    }
    @QueryMapping
    public Compte findAccount(@Argument String id){
        return compteRepository.findById(id).orElseThrow(()->new RuntimeException("account not founds"));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO compte){
        return accountService.addAccount(compte);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO compte){
        return accountService.updateCompte(id,accountMapper.fromRequestDTO(compte));
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
         accountService.deleteById(id);
         return true;
    }
}