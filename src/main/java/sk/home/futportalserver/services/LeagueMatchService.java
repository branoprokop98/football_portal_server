package sk.home.futportalserver.services;

import org.springframework.stereotype.Service;
import sk.home.futportalserver.domain.LeagueMatch;
import sk.home.futportalserver.domain.LeagueMatchPK;
import sk.home.futportalserver.domain.Match;
import sk.home.futportalserver.domain.repositories.LeagueMatchRepository;

import java.util.List;

@Service
public class LeagueMatchService {
    private final LeagueMatchRepository leagueMatchRepository;

    public LeagueMatchService(LeagueMatchRepository leagueMatchRepository) {
        this.leagueMatchRepository = leagueMatchRepository;
    }

    public void saveLeagueMatch(LeagueMatch leagueMatch) {
        leagueMatchRepository.save(leagueMatch);
    }

    public List<LeagueMatch> getAllMatchesByLeagueId(Long id) {
        return leagueMatchRepository.findAllByLeagueId(id);
    }

    public List<LeagueMatch> getAllMatchesByLeagueIdAndRound(Long id, Integer round) {
        return leagueMatchRepository.findAllByLeagueIdAndRound(id, round);
    }

    public List<LeagueMatch> getLatestMatchesInLeague(Long leagueId) {
        return getAllMatchesByLeagueIdAndRound(leagueId, leagueMatchRepository.getNewestRound(leagueId));
    }

    public List<Integer> getAllRounds(Long leagueId) {
        return leagueMatchRepository.findDistinctByRound(leagueId);
    }
}
