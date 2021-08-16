package sk.home.futportalserver.services;

import org.springframework.stereotype.Service;
import sk.home.futportalserver.domain.Season;
import sk.home.futportalserver.domain.repositories.SeasonRepository;

import java.util.List;

@Service
public class SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }

    public void saveSeason(Season season){
        seasonRepository.save(season);
    }

    public Season findSeasonById(Long id){
        return seasonRepository.findSeasonById(id);
    }
}
