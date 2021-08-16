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
}
