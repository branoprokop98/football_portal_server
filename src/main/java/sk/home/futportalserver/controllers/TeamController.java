package sk.home.futportalserver.controllers;

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
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/getTeamsByLeagueId/{id}")
    public List<Team> getTeamsByLeagueId(@PathVariable Long id){
        return teamService.getTeamsByLeagueId(id);
    }
}
