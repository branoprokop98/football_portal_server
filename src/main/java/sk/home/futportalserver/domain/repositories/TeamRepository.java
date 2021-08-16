package sk.home.futportalserver.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.home.futportalserver.domain.League;
import sk.home.futportalserver.domain.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByLeagueIdOrderByPointsDesc(Long id);
}
