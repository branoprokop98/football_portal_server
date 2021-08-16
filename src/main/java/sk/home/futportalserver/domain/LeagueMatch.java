package sk.home.futportalserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter
@Setter
public class LeagueMatch {

    @EmbeddedId
    private LeagueMatchPK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("leagueId")
    @JoinColumn(name = "leagueid")
    private League league;

    private Integer round;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("matchId")
    @JoinColumn(name = "matchid")
    private Match match;

    public LeagueMatch() {
        this.id = new LeagueMatchPK();
    }

    public LeagueMatch(League league, Integer round, Match match) {
        this.id = new LeagueMatchPK();
        this.league = league;
        this.round = round;
        this.match = match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Match getMatch() {
        return match;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public League getLeague() {
        return league;
    }

    public LeagueMatchPK getId() {
        return id;
    }

    public void setId(LeagueMatchPK id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
