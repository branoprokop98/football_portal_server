package sk.home.futportalserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.services.LeagueService;

import java.util.List;

@RestController
@RequestMapping("league")
@CrossOrigin(origins = "http://localhost:4200")
public class LeagueController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<League>> getAllLeagues(){
        return ResponseEntity.ok().body(leagueService.getAllLeagues());
    }

    @GetMapping("/getLeagues/{id}")
    public List<League> getLeaguesBySeasonId(@PathVariable Long id){
        return leagueService.getLeaguesBySeasonId(id);
    }
}
