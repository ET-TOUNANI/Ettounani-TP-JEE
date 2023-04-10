package ma.enset.spring_micro_service.web;

import ma.enset.spring_micro_service.entities.Compte;
import ma.enset.spring_micro_service.repository.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CompteRestfullController {
    private CompteRepository compteRepository;

    public CompteRestfullController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
    @GetMapping("/compte")
    public List<Compte> comptes(){
        return compteRepository.findAll();
    }
    @GetMapping("/compte/{id}")
    public Compte compte(@PathVariable String id){
        return compteRepository.findById(id).orElseThrow(()->new RuntimeException("count not found"));
    }
    @PostMapping("/compte")
    public Compte save(@RequestBody Compte compte){
        compte.setId(UUID.randomUUID().toString());
        return compteRepository.save(compte);
    }
    @PutMapping("/compte")
    public Compte update( @PathVariable String id,@RequestBody Compte compte){
        Compte compte1 = compteRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        if (compte.getBalance()!= null) compte1.setBalance(compte.getBalance());
        if (compte.getCurrency()!= null)compte1.setCurrency(compte.getCurrency());
        if (compte.getCreateDate()!= null)compte1.setCreateDate(compte.getCreateDate());
        if (compte.getType()!= null)compte1.setType(compte.getType());
        return compteRepository.save(compte1);
    }
    @DeleteMapping("/compte/{id}")
    public void deleteCompte(@PathVariable String id){
        compteRepository.deleteById(id);
    }
}
