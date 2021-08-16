package sk.home.futportalserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer homeGoals;
    private Integer guestGoals;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Team guestTeam;

    public Match(Long id, Integer homeGoals, Integer guestGoals, Team homeTeam, Team guestTeam) {
        this.id = id;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        updateHomeTeamScoredGoals();
        updateHomeTeamCollectedGoals();
        updateGuestTeamScoredGoals();
        updateGuestTeamCollectedGoals();
        updateStats();
        updatePlayedMatches();
    }

    private void updateHomeTeamScoredGoals() {
        this.homeTeam.setScoredGoals(this.homeGoals);
    }

    private void updateHomeTeamCollectedGoals() {
        this.homeTeam.setCollectedGoals(this.guestGoals);
    }

    private void updateGuestTeamScoredGoals() {
        this.guestTeam.setScoredGoals(this.guestGoals);
    }

    private void updateGuestTeamCollectedGoals() {
        this.guestTeam.setCollectedGoals(this.homeGoals);
    }

    private void updateStats() {
        if (this.homeGoals > this.guestGoals) {
            homeTeam.updateWinnings();
            guestTeam.updateLooses();
            homeTeam.updatePointsForWin();
        } else if (this.homeGoals < this.guestGoals) {
            homeTeam.updateLooses();
            guestTeam.updateWinnings();
            guestTeam.updatePointsForWin();
        } else{
            homeTeam.updateDraws();
            guestTeam.updateDraws();
            homeTeam.updatePointsForDraw();
            guestTeam.updatePointsForDraw();
        }
    }

    private void updatePlayedMatches(){
        this.homeTeam.updateMatches();
        this.guestTeam.updateMatches();
    }
}
