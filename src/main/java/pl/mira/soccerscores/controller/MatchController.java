package pl.mira.soccerscores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mira.soccerscores.footballdataclient.boundary.FootballDataService;
import pl.mira.soccerscores.footballdataclient.entity.request.CompetitionMatchRequest;
import pl.mira.soccerscores.footballdataclient.entity.response.BasicCompetitionMatchResponse;

import java.time.LocalDate;

@Controller
public class MatchController {

    private final FootballDataService footballDataService;

    public MatchController(FootballDataService footballDataService) {
        this.footballDataService = footballDataService;
    }

/*    @GetMapping
    public String getPLMatch(Model model) {
        Competition competition = resultClient.getCompetitionById(CompetitionEnum.PREMIER_LEAGUE.getId());
        CompetitionMatchRequest competitionMatchRequest = new CompetitionMatchRequest(
                CompetitionEnum.PREMIER_LEAGUE.getCode(),
                competition.currentSeason().startDate().getYear(),
                null,
                null,
                null,
                competition.currentSeason().currentMatchday());
        CompetitionMatchResponse competitionMatchResponse = resultClient.getMatchesByCompetitionMatchRequest(competitionMatchRequest);
        model.addAttribute("competitionMatchResponse", competitionMatchResponse);
        return "index";
    }   */

    @GetMapping
    public String getAllMatchToday(Model model) {
        LocalDate currentDate = LocalDate.now();
        CompetitionMatchRequest competitionMatchRequest = new CompetitionMatchRequest(
                null,
                null,
                null,
                currentDate,
                currentDate.plusDays(3),
                null);
        BasicCompetitionMatchResponse competitionMatchResponse = footballDataService.getBasicCompetitionMatchResponse(competitionMatchRequest);
        model.addAttribute("competitionMatchResponse", competitionMatchResponse);
        return "index";
    }

}
