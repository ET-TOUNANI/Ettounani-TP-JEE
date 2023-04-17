package ettounani_abderrahmane.metier;

import ettounani_abderrahmane.DAO.entities.Abonnement;
import ettounani_abderrahmane.DAO.repository.AbonnementRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementService implements IAbonnementService{
    private AbonnementRepository abonnementRepository;
    @Override
    public Page<Abonnement> getAbonnementsByMontant(String keyword, Pageable pageable) {
        if(keyword.isEmpty())return abonnementRepository.findAll(pageable);
        return abonnementRepository.findAllByMontantMensuel(Double.parseDouble(keyword),pageable);
    }

    @Override
    public void deleteById(long id) {
        abonnementRepository.deleteById(id);
    }

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return abonnement;
    }

    @Override
    public Abonnement updateAbonnement(Long id, Abonnement abonnement) {
        abonnement.setId(id);
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement findById(Long id) {
        return abonnementRepository.findById(id).orElse(new Abonnement());
    }

    @Override
    public List<Abonnement> findAll() {
        return abonnementRepository.findAll();
    }
}
