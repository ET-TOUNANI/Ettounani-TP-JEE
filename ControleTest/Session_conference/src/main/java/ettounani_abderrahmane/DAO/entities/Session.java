package ettounani_abderrahmane.DAO.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy = "session")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Inscription>inscriptions;
    @ManyToOne
    private Moderateur moderateur;
    @OneToMany(mappedBy = "session")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Conference>conferences;

}
