package sk.home.futportalserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.home.futportalserver.domain.Season;
import sk.home.futportalserver.services.SeasonService;

import java.util.List;

@RequestMapping("season")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeasonController {

    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Season>> getAllSeasons(){
        return ResponseEntity.ok().body(seasonService.getAllSeasons());
    }

    @GetMapping("/getSeason/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Long id){
        return ResponseEntity.ok().body(seasonService.findSeasonById(id));
    }

    @GetMapping("getAllSeasonWhereIsLeague/{nameOfLeague}")
    public ResponseEntity<List<Season>> getAllSeasonsWhereIsLeague(@PathVariable String nameOfLeague){
        return ResponseEntity.ok().body(seasonService.findAllSeasonWhichContainsLeagueByName(nameOfLeague));
    }
}
