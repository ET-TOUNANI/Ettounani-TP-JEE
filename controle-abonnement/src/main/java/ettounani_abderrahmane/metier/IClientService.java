package ettounani_abderrahmane.metier;

import ettounani_abderrahmane.DAO.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientService {
     Client addClient(Client client);
     Page<Client> getClientsByName(String Name, Pageable pageable );

    void deleteById(long id);

    List<Client> findAll();

    Client findById(Long id);

    Client updateClient(Long id, Client client);
}
