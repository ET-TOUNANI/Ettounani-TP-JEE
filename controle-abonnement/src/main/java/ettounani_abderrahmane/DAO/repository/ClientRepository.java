package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findAllByNameContains(String name, Pageable pageable);
}
