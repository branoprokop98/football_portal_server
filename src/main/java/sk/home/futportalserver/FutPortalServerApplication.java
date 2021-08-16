package sk.home.futportalserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.home.futportalserver.domain.*;
import sk.home.futportalserver.services.*;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class FutPortalServerApplication implements CommandLineRunner {

    private final LeagueService leagueService;
    private final SeasonService seasonService;
    private final MatchService matchService;
    private final TeamService teamService;
    private final LeagueMatchSeasonService leagueMatchSeasonService;

    public FutPortalServerApplication(LeagueService leagueService, SeasonService seasonService, MatchService matchService, TeamService teamService, LeagueMatchSeasonService leagueMatchSeasonService) {
        this.leagueService = leagueService;
        this.seasonService = seasonService;
        this.matchService = matchService;
        this.teamService = teamService;
        this.leagueMatchSeasonService = leagueMatchSeasonService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FutPortalServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        League league1 = new League(null, "Východ");
        League league2 = new League(null, "Stred");
        League league3 = new League(null, "Západ");

        leagueService.saveLeague(league1);
        leagueService.saveLeague(league2);
        leagueService.saveLeague(league3);

        Season season1 = new Season(null, Arrays.asList(league3), "2019/2020");
        Season season2 = new Season(null, Arrays.asList(league1, league2), "2020/2021");

        seasonService.saveSeason(season1);
        seasonService.saveSeason(season2);

        Team team1 = new Team(null, "Nižný Tvarožec", league1, new ArrayList<>(), new ArrayList<>());
        Team team2 = new Team(null, "Sveržov", league1, new ArrayList<>(), new ArrayList<>());
        Team team3 = new Team(null, "Gaboltov", league1, new ArrayList<>(), new ArrayList<>());
        Team team4 = new Team(null, "Demjata", league1, new ArrayList<>(), new ArrayList<>());

        Match match1 = new Match(null, 2, 3, team1, team2);
        Match match2 = new Match(null, 1, 1, team3, team4);

//        team1.getHomeMatches().add(match1);
//        team2.getGuestMatches().add(match1);
//
//        team3.getHomeMatches().add(match2);
//        team4.getGuestMatches().add(match2);

        LeagueMatchSeason leagueMatchSeason1 = new LeagueMatchSeason(league1, 1, match1, season1);
        LeagueMatchSeason leagueMatchSeason2 = new LeagueMatchSeason(league1, 1, match2, season1);

        teamService.saveTeam(team1);
        teamService.saveTeam(team2);
        teamService.saveTeam(team3);
        teamService.saveTeam(team4);

        matchService.saveMatch(match1);
        matchService.saveMatch(match2);

        leagueMatchSeasonService.saveLeagueMatch(leagueMatchSeason1);
        leagueMatchSeasonService.saveLeagueMatch(leagueMatchSeason2);

//        List<Integer> leagueMatches = leagueMatchService.getAllRounds(1L);
//        List<Integer> leagueMatches2 = leagueMatchService.getAllRounds(2L);

    }
}
