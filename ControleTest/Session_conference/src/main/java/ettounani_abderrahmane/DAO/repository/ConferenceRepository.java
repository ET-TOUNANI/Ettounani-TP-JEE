package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Conference;
import ettounani_abderrahmane.DAO.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
