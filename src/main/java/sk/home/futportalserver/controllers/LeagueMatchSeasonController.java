package sk.home.futportalserver.controllers;

import org.springframework.web.bind.annotation.*;
import sk.home.futportalserver.domain.LeagueMatchSeason;
import sk.home.futportalserver.services.LeagueMatchSeasonService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("leagueMatch")
public class LeagueMatchSeasonController {

    private final LeagueMatchSeasonService leagueMatchSeasonService;

    public LeagueMatchSeasonController(LeagueMatchSeasonService leagueMatchSeasonService) {
        this.leagueMatchSeasonService = leagueMatchSeasonService;
    }

    @GetMapping("getMatchesByLeague/{id}")
    public List<LeagueMatchSeason> getMatchesByLeagueId(@PathVariable Long id) {
        return leagueMatchSeasonService.getAllMatchesByLeagueId(id);
    }

    @GetMapping("getAllRoundsInLeagues/{id}")
    public List<Integer> getAllRoundsInLeagues(@PathVariable Long id) {
        return leagueMatchSeasonService.getAllRounds(id);
    }

    @GetMapping("matchesByLeagueAndRound/{leagueId}/{round}")
    public List<LeagueMatchSeason> getMatchesByLeagueAndRound(@PathVariable Long leagueId, @PathVariable Integer round) {
        return leagueMatchSeasonService.getAllMatchesByLeagueIdAndRound(leagueId, round);
    }

    @GetMapping("latestMatchesInLeague/{id}")
    public List<LeagueMatchSeason> getLatestMatchesInLeague(@PathVariable Long id) {
        return leagueMatchSeasonService.getLatestMatchesInLeague(id);
    }

    @GetMapping("matchesInLeagueAndSeasonByRound/{leagueId}/{seasonId}/{round}")
    public List<LeagueMatchSeason> getAllMatchesByRoundInLeagueInSeason(@PathVariable Long leagueId, @PathVariable Long seasonId, @PathVariable Integer round) {
        return leagueMatchSeasonService.getAllMatchesInLeagueInSeasonByRound(leagueId, seasonId, round);
    }
}
