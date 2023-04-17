package ettounani_abderrahmane.web.restFull;
import ettounani_abderrahmane.DAO.entities.Abonnement;
import ettounani_abderrahmane.DAO.entities.Client;
import ettounani_abderrahmane.metier.IAbonnementService;
import ettounani_abderrahmane.metier.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClientAbonnementRestfullController {
    private IClientService clientService;
    private IAbonnementService abonnementService;

    @GetMapping("/client")
    public List<Client> clients() {
        return clientService.findAll();
    }

    @GetMapping("/client/{id}")
    public Client client(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping("/client")
    public Client save(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/client/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
    }
    @GetMapping("/abonnement")
    public List<Abonnement> abonnements() {
        return abonnementService.findAll();
    }

    @GetMapping("/abonnement/{id}")
    public Abonnement abonnement(@PathVariable Long id) {
        return abonnementService.findById(id);
    }

    @PostMapping("/abonnement")
    public Abonnement save(@RequestBody Abonnement abonnement) {
        return abonnementService.addAbonnement(abonnement);
    }

    @PutMapping("/abonnement/{id}")
    public Abonnement update(@PathVariable Long id, @RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(id, abonnement);
    }

    @DeleteMapping("/abonnement/{id}")
    public void deleteAbonnement(@PathVariable Long id) {
        abonnementService.deleteById(id);
    }
}