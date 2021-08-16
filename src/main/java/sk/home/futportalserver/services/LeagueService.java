package sk.home.futportalserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.domain.Season;
import sk.home.futportalserver.domain.repositories.LeagueRepository;

import java.util.List;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getAllLeagues(){
        return leagueRepository.findAll();
        //return leagueRepository.getIdAndNameOfAllLeague();
    }

    public void saveLeague(League league){
        leagueRepository.save(league);
    }

    public List<League> getLeaguesBySeasonId(Long id){
        return leagueRepository.getLeaguesBySeasonId(id);
    }


}
