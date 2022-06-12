package sk.home.futportalserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.home.futportalserver.domain.Team;
import sk.home.futportalserver.services.TeamService;

import java.util.List;

@RequestMapping("team")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Team>> getAllTeams(){
        return ResponseEntity.ok().body(teamService.getAllTeams());
    }

    @GetMapping("/getTeamsByLeagueId/{id}")
    public ResponseEntity<List<Team>> getTeamsByLeagueId(@PathVariable Long id){
        return ResponseEntity.ok().body(teamService.getTeamsByLeagueId(id));
    }
}
