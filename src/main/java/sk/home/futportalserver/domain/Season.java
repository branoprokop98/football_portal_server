package sk.home.futportalserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "Season")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinTable(name = "SEASON_LEAGUE",
        joinColumns = @JoinColumn(name = "SEASON_ID"),
        inverseJoinColumns = @JoinColumn(name = "LEAGUE_ID"))
    @ManyToMany
    List<League> leagues;

    private String year;
}
