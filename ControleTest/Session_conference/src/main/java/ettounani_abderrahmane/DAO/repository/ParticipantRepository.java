package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Participant;
import ettounani_abderrahmane.DAO.entities.Salle;
import ettounani_abderrahmane.DAO.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {

    List<Participant> getParticipantByRole(String role);
}
