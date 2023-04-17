package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Inscription;
import ettounani_abderrahmane.DAO.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}
