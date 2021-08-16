package sk.home.futportalserver.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.home.futportalserver.domain.LeagueMatch;
import sk.home.futportalserver.domain.LeagueMatchPK;
import sk.home.futportalserver.domain.Match;

import java.util.List;

@Repository
public interface LeagueMatchRepository extends JpaRepository<LeagueMatch, Long> {

    List<LeagueMatch> findAllByLeagueId(Long id);
    List<LeagueMatch> findAllByLeagueIdAndRound(Long leagueId, Integer round);

    List<LeagueMatch> findMatchesByLeagueIdAndRound(Long id, Integer round);

    List<LeagueMatch> findAllByLeague_Id(Long id);

    @Query(value = "select max(a.round) from LeagueMatch a where a.league.id = ?1")
    Integer getNewestRound(Long id);

    @Query(value = "select distinct a.round from LeagueMatch a where a.league.id = ?1")
    List<Integer> findDistinctByRound(Long leagueId);
}
