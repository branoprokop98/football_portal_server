package sk.home.futportalserver.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.domain.Season;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    Season findSeasonById(Long id);

    @Query(value = "select s from Season s inner join s.leagues d where d.name = ?1")
    List<Season> findAllSeasonWhichContainsLeagueByName(String nameOfLeague);

    @Query(value = "select d.id from Season s inner join s.leagues d where d.name = ?1 and s.year = ?2")
    Integer getLeagueIdByLeagueNameAndYear(String nameOfLeague, String seasonYear);
}
