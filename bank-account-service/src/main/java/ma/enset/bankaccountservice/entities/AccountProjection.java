package ma.enset.bankaccountservice.entities;

import ma.enset.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "accountProjection1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();



}
