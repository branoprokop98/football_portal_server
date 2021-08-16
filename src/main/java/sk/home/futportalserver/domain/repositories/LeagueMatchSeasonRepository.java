package sk.home.futportalserver.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.home.futportalserver.domain.LeagueMatchSeason;

import java.util.List;

@Repository
public interface LeagueMatchSeasonRepository extends JpaRepository<LeagueMatchSeason, Long> {

    List<LeagueMatchSeason> findAllByLeagueId(Long id);
    List<LeagueMatchSeason> findAllByLeagueIdAndRound(Long leagueId, Integer round);

    List<LeagueMatchSeason> findMatchesByLeagueIdAndRound(Long id, Integer round);

    List<LeagueMatchSeason> findAllByLeagueIdAndSeasonIdAndRound(Long leagueId, Long seasonId, Integer round);

    List<LeagueMatchSeason> findAllByLeague_Id(Long id);

    @Query(value = "select max(a.round) from LeagueMatchSeason a where a.league.id = ?1")
    Integer getNewestRound(Long id);

    @Query(value = "select distinct a.round from LeagueMatchSeason a where a.league.id = ?1")
    List<Integer> findDistinctByRound(Long leagueId);
}
