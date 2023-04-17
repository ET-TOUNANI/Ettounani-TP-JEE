package ettounani_abderrahmane.metier;

import ettounani_abderrahmane.DAO.entities.Abonnement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAbonnementService {
    Page<Abonnement> getAbonnementsByMontant(String keyword, Pageable pageable);

    void deleteById(long id);

    Abonnement addAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement(Long id, Abonnement abonnement);

    Abonnement findById(Long id);

    List<Abonnement> findAll();
}
