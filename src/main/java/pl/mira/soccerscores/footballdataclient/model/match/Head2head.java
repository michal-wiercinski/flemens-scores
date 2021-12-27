package pl.mira.soccerscores.footballdataclient.model.match;

public record Head2head
        (int numberOfMatches,
         int totalGoals,
         MatchTeam homeTeam,
         MatchTeam awayTeam) {
}
