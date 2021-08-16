package sk.home.futportalserver.services;

import org.springframework.stereotype.Service;
import sk.home.futportalserver.domain.LeagueMatchSeason;
import sk.home.futportalserver.domain.repositories.LeagueMatchSeasonRepository;

import java.util.List;

@Service
public class LeagueMatchSeasonService {
    private final LeagueMatchSeasonRepository leagueMatchSeasonRepository;

    public LeagueMatchSeasonService(LeagueMatchSeasonRepository leagueMatchSeasonRepository) {
        this.leagueMatchSeasonRepository = leagueMatchSeasonRepository;
    }

    public void saveLeagueMatch(LeagueMatchSeason leagueMatchSeason) {
        leagueMatchSeasonRepository.save(leagueMatchSeason);
    }

    public List<LeagueMatchSeason> getAllMatchesByLeagueId(Long id) {
        return leagueMatchSeasonRepository.findAllByLeagueId(id);
    }

    public List<LeagueMatchSeason> getAllMatchesByLeagueIdAndRound(Long id, Integer round) {
        return leagueMatchSeasonRepository.findAllByLeagueIdAndRound(id, round);
    }

    public List<LeagueMatchSeason> getLatestMatchesInLeague(Long leagueId) {
        return getAllMatchesByLeagueIdAndRound(leagueId, leagueMatchSeasonRepository.getNewestRound(leagueId));
    }

    public List<Integer> getAllRounds(Long leagueId) {
        return leagueMatchSeasonRepository.findDistinctByRound(leagueId);
    }

    public List<LeagueMatchSeason> getAllMatchesInLeagueInSeasonByRound(Long leagueId, Long seasonId, Integer round) {
        return leagueMatchSeasonRepository.findAllByLeagueIdAndSeasonIdAndRound(leagueId, seasonId, round);
    }
}
