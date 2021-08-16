package sk.home.futportalserver.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer winnings = 0;
    private Integer looses = 0;
    private Integer draws = 0;
    private Integer points = 0;
    private Integer scoredGoals = 0;
    private Integer collectedGoals = 0;
    private Integer matches = 0;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;


//    @OneToMany(mappedBy = "homeTeam")
//    private List<Match> homeMatches;
//
//    @OneToMany(mappedBy = "guestTeam")
//    private List<Match> guestMatches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Team team = (Team) o;

        return Objects.equals(id, team.id);
    }

    public Team(Long id, String name, League league, List<Match> homeMatches, List<Match> guestMatches) {
        this.id = id;
        this.name = name;
        this.league = league;
//        this.homeMatches = homeMatches;
//        this.guestMatches = guestMatches;
    }

    @Override
    public int hashCode() {
        return 1948895937;
    }

    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals += scoredGoals;
    }

    public Integer getCollectedGoals() {
        return collectedGoals;
    }

    public void setCollectedGoals(Integer collectedGoals) {
        this.collectedGoals += collectedGoals;
    }

    public void updateWinnings(){
        this.winnings++;
    }

    public void updateLooses(){
        this.looses++;
    }

    public void updateDraws(){
        this.draws++;
    }

    public void updatePointsForWin(){
        this.points += 3;
    }

    public void updatePointsForDraw(){
        this.points += 1;
    }

    public void updateMatches(){
        this.matches += 1;
    }
}
