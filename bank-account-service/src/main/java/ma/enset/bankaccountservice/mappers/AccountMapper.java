package ma.enset.bankaccountservice.mappers;

import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;

import ma.enset.bankaccountservice.entities.AccountProjection;
import ma.enset.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public List<BankAccountResponseDTO> fromAccountProjections(List<AccountProjection> accountProjections){
        List<BankAccountResponseDTO> bankAccountResponseDTOS = new ArrayList<>();
        for(AccountProjection accountProjection : accountProjections){
            BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
            BeanUtils.copyProperties(accountProjection, bankAccountResponseDTO);
            bankAccountResponseDTOS.add(bankAccountResponseDTO);
        }
        return bankAccountResponseDTOS;
    }

}
