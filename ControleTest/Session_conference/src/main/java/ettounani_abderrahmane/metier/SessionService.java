package ettounani_abderrahmane.metier;

import ettounani_abderrahmane.DAO.entities.Session;
import ettounani_abderrahmane.DAO.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {
    private SessionRepository sessionRepository;

    public Page<Session> getSessions(String name, Pageable pageable){
        return sessionRepository.findAllByNameContains(name,pageable);
    }

}
