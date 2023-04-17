package ettounani_abderrahmane.DAO.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Time startHour;
    @Temporal(TemporalType.TIME)
    private Time endHour;
    private String description;
    @ManyToOne
    private Session session;
    @OneToMany(mappedBy = "conference")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Commentaire>commentaires;
    @ManyToOne
    private Speaker speaker;


}
