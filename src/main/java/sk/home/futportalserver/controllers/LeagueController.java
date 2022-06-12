package sk.home.futportalserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.services.LeagueService;
import sk.home.futportalserver.services.SeasonService;

import java.util.List;

@RestController
@RequestMapping("league")
@CrossOrigin(origins = "http://localhost:4200")
public class LeagueController {

    private final LeagueService leagueService;
    private final SeasonService seasonService;

    @Autowired
    public LeagueController(LeagueService leagueService, SeasonService seasonService) {
        this.leagueService = leagueService;
        this.seasonService = seasonService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<League>> getAllLeagues(){
        return ResponseEntity.ok().body(leagueService.getAllLeagues());
    }

    @GetMapping("/getLeagues/{id}")
    public ResponseEntity<List<League>> getLeaguesBySeasonId(@PathVariable Long id){
        return ResponseEntity.ok().body(leagueService.getLeaguesBySeasonId(id));
    }

    @GetMapping("/getLeague/{leagueId}")
    public ResponseEntity<League> getLeagueById(@PathVariable Long leagueId){
        return ResponseEntity.ok().body(leagueService.getLeagueById(leagueId));
    }

    @GetMapping("getIdOfLeagueBySeasonAndName/{nameOfLeague}/{year}")
    public Integer getLeagueId(@PathVariable String nameOfLeague, @PathVariable String year){
        return  seasonService.getLeagueIdBySeasonYearAndLeagueName(nameOfLeague, year);
    }
}
