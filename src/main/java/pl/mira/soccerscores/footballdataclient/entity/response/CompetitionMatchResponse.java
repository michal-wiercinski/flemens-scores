package pl.mira.soccerscores.footballdataclient.entity.response;

import pl.mira.soccerscores.footballdataclient.model.Competition;
import pl.mira.soccerscores.footballdataclient.model.Filters;
import pl.mira.soccerscores.footballdataclient.model.match.Match;

import java.util.List;

public record CompetitionMatchResponse
        (int count,
         Filters filters,
         Competition competition,
         List<Match> matches) {
}
