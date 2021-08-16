package sk.home.futportalserver.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LeagueMatchPK implements Serializable {
    private Long leagueId;
    private Long matchId;

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}
