package sk.home.futportalserver.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "league")
//    private List<LeagueMatch> leagueMatches;

    public League(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        League league = (League) o;

        return Objects.equals(id, league.id);
    }

    @Override
    public int hashCode() {
        return 1070432207;
    }
}
