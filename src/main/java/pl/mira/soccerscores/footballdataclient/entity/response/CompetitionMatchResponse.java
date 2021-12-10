package pl.mira.soccerscores.footballdataclient.entity.response;

import lombok.Getter;
import lombok.Setter;
import pl.mira.soccerscores.model.Competition;
import pl.mira.soccerscores.model.Filters;
import pl.mira.soccerscores.model.match.Match;

import java.util.List;

@Getter
@Setter
public class CompetitionMatchResponse {
    private int count;
    private Filters filters;
    private Competition competition;
    private List<Match> matches;
}
