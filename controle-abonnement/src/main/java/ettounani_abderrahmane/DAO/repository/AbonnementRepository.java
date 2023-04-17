package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Abonnement;
import ettounani_abderrahmane.DAO.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    Page<Abonnement> findAllByMontantMensuel(Double montant, Pageable pageable);
}
