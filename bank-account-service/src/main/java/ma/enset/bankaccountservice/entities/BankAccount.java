package ma.enset.bankaccountservice.entities;

import lombok.*;
import ma.enset.bankaccountservice.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class BankAccount {
    @Id
    private String id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
