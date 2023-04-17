package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
    public Page<Session>findAllByNameContains(String name, Pageable pageable);
}
