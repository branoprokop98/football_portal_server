package sk.home.futportalserver.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.home.futportalserver.domain.Match;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
