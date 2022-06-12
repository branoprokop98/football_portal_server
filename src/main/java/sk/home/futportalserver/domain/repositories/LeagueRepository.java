package sk.home.futportalserver.domain.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.domain.Season;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    @Query("select s.leagues from Season s where s.id = ?1")
    List<League> getLeaguesBySeasonId(Long id);

    @Query(value = "select l.id, l.name from League l")
    List<League> getIdAndNameOfAllLeague();

    League findLeagueById(Long id);
}
