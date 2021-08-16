package sk.home.futportalserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.home.futportalserver.domain.Match;
import sk.home.futportalserver.domain.repositories.MatchRepository;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void saveMatch(Match match){
        matchRepository.save(match);
    }

    public List<Match> getAllMatches(){
        return matchRepository.findAll();
    }

}
