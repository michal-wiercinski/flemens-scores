package pl.mira.footballdataclient.entity.response;

import pl.mira.soccerscores.model.Competition;
import pl.mira.soccerscores.model.Filters;
import pl.mira.soccerscores.model.match.Match;

import java.util.List;

public record CompetitionMatchResponse
        (int count,
         Filters filters,
         Competition competition,
         List<Match> matches) {
}
