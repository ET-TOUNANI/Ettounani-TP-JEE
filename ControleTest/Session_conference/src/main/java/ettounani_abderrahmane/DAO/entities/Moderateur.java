package ettounani_abderrahmane.DAO.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ROLE_MODERATEUR")
public class Moderateur extends Participant{
    private String speciality;
    @OneToMany(mappedBy = "moderateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Session>sessions;
}
