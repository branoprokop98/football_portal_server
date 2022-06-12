package sk.home.futportalserver.controllers;

import org.springframework.http.ResponseEntity;
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

    @GetMapping("getMatchesInLeague/{leagueId}")
    public ResponseEntity<List<LeagueMatchSeason>> getMatchesByLeagueId(@PathVariable Long leagueId) {
        return ResponseEntity.ok().body(leagueMatchSeasonService.getAllMatchesByLeagueId(leagueId));
    }

    @GetMapping("getAllRoundsInLeagues/{leagueId}")
    public ResponseEntity<List<Integer>> getAllRoundsInLeagues(@PathVariable Long leagueId) {
        return ResponseEntity.ok().body(leagueMatchSeasonService.getAllRounds(leagueId));
    }

    @GetMapping("matchesByLeagueAndRound/{leagueId}/{round}")
    public ResponseEntity<List<LeagueMatchSeason>> getMatchesByLeagueAndRound(@PathVariable Long leagueId, @PathVariable Integer round) {
        return ResponseEntity.ok().body(leagueMatchSeasonService.getAllMatchesByLeagueIdAndRound(leagueId, round));
    }

    @GetMapping("latestMatchesInLeague/{id}")
    public ResponseEntity<List<LeagueMatchSeason>> getLatestMatchesInLeague(@PathVariable Long id) {
        return ResponseEntity.ok().body(leagueMatchSeasonService.getLatestMatchesInLeague(id));
    }

    @GetMapping("matchesInLeagueAndSeasonByRound/{leagueId}/{seasonId}/{round}")
    public ResponseEntity<List<LeagueMatchSeason>> getAllMatchesByRoundInLeagueInSeason(@PathVariable Long leagueId, @PathVariable Long seasonId, @PathVariable Integer round) {
        return ResponseEntity.ok().body(leagueMatchSeasonService.getAllMatchesInLeagueInSeasonByRound(leagueId, seasonId, round));
    }

    @GetMapping("/getLatestRound/{leagueId}")
    public ResponseEntity<String> getLatestRound(@PathVariable Long leagueId) {
        return ResponseEntity.ok().body(leagueMatchSeasonService.getLatestRound(leagueId).toString());
    }
}
