package ettounani_abderrahmane.metier;

import ettounani_abderrahmane.DAO.entities.Client;
import ettounani_abderrahmane.DAO.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{
    private ClientRepository clientRepository;
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Page<Client> getClientsByName(String Name, Pageable pageable) {
        return clientRepository.findAllByNameContains(Name,pageable);
    }

    @Override
    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    @Override
    public Client updateClient(Long id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }
}
