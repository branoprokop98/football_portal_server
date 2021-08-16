package sk.home.futportalserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.domain.Team;
import sk.home.futportalserver.domain.repositories.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(Team team){
        teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public List<Team> getTeamsByLeagueId(Long id){
        return teamRepository.findAllByLeagueIdOrderByPointsDesc(id);
    }
}
