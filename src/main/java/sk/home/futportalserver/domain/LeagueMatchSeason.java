package sk.home.futportalserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LeagueMatchSeason {

    @EmbeddedId
    private LeagueMatchSeasonPK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("leagueId")
    @JoinColumn(name = "leagueid")
    private League league;

    private Integer round;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("matchId")
//    @JoinColumn(name = "matchid")
    @OneToOne(orphanRemoval = true)
    @MapsId("matchId")
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @MapsId("seasonId")
    @JoinColumn(name = "season_id")
    private Season season;

    public LeagueMatchSeason() {
        this.id = new LeagueMatchSeasonPK();
    }

    public LeagueMatchSeason(League league, Integer round, Match match, Season season) {
        this.id = new LeagueMatchSeasonPK();
        this.league = league;
        this.round = round;
        this.match = match;
        this.season = season;
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

    public LeagueMatchSeasonPK getId() {
        return id;
    }

    public void setId(LeagueMatchSeasonPK id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
