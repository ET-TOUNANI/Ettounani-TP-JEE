package ettounani_abderrahmane.DAO.repository;

import ettounani_abderrahmane.DAO.entities.Commentaire;
import ettounani_abderrahmane.DAO.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
}
