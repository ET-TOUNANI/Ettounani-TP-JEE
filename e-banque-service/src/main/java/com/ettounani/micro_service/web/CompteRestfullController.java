package com.ettounani.micro_service.web;

import com.ettounani.micro_service.dto.BankAccountRequestDTO;
import com.ettounani.micro_service.dto.BankAccountResponseDTO;
import com.ettounani.micro_service.entities.Compte;
import com.ettounani.micro_service.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CompteRestfullController {
    private AccountService accountService;


    @GetMapping("/compte")
    public List<BankAccountResponseDTO> comptes() {
        return accountService.findAll();
    }

    @GetMapping("/compte/{id}")
    public BankAccountResponseDTO compte(@PathVariable String id) {
        return accountService.findById(id);
    }

    @PostMapping("/compte")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO compte) {
        return accountService.addAccount(compte);
    }

    @PutMapping("/compte/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody Compte compte) {
        return accountService.updateCompte(id, compte);
    }

    @DeleteMapping("/compte/{id}")
    public void deleteCompte(@PathVariable String id) {
        accountService.deleteById(id);
    }
}