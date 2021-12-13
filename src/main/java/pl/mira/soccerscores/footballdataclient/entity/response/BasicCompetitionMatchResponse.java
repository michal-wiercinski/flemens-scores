package pl.mira.soccerscores.footballdataclient.entity.response;

import pl.mira.soccerscores.model.Competition;
import pl.mira.soccerscores.model.Filters;
import pl.mira.soccerscores.model.match.Match;

import java.util.List;

public record BasicCompetitionMatchResponse (int count,
                                             Filters filters,
                                             List<Match> matches) {
}