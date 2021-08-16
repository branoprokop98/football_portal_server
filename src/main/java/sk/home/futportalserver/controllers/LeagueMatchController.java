package sk.home.futportalserver.controllers;

import org.springframework.web.bind.annotation.*;
import sk.home.futportalserver.domain.LeagueMatch;
import sk.home.futportalserver.domain.LeagueMatchPK;
import sk.home.futportalserver.domain.Match;
import sk.home.futportalserver.services.LeagueMatchService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("leagueMatch")
public class LeagueMatchController {

    private final LeagueMatchService leagueMatchService;

    public LeagueMatchController(LeagueMatchService leagueMatchService) {
        this.leagueMatchService = leagueMatchService;
    }

    @GetMapping("getMatchesByLeague/{id}")
    public List<LeagueMatch> getMatchesByLeagueId(@PathVariable Long id) {
        return leagueMatchService.getAllMatchesByLeagueId(id);
    }

    @GetMapping("getAllRoundsInLeagues/{id}")
    public List<Integer> getAllRoundsInLeagues(@PathVariable Long id) {
        return leagueMatchService.getAllRounds(id);
    }

    @GetMapping("matches/{id}/{round}")
    public List<LeagueMatch> getMatchesByLeagueAndRound(@PathVariable Long id, @PathVariable Integer round) {
        return leagueMatchService.getAllMatchesByLeagueIdAndRound(id, round);
    }

    @GetMapping("latestMatchesInLeague/{id}")
    public List<LeagueMatch> getLatestMatchesInLeague(@PathVariable Long id) {
        return leagueMatchService.getLatestMatchesInLeague(id);
    }
}
