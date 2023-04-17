package ettounani_abderrahmane.DAO.entities;

import ettounani_abderrahmane.DAO.entities.enums.Gender;
import ettounani_abderrahmane.DAO.entities.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

// ADMIN
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role",length = 20)
public  class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String urlImage;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "role", insertable = false, updatable = false)
    private String role;
    @OneToMany(mappedBy = "participant")
    private Collection<Commentaire>commentaires;

}
