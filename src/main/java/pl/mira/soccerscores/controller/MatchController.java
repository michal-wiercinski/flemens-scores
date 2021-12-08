package pl.mira.soccerscores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mira.soccerscores.footballdataclient.control.RestClient;
import pl.mira.soccerscores.footballdataclient.entity.request.CompetitionMatchRequest;
import pl.mira.soccerscores.footballdataclient.entity.response.CompetitionMatchResponse;
import pl.mira.soccerscores.model.Competition;
import pl.mira.soccerscores.model.enums.CompetitionEnum;

@Controller
public class MatchController {

    private final RestClient resultClient;

    public MatchController(final RestClient resultClient) {
        this.resultClient = resultClient;
    }

    @GetMapping
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
    }
}
