package pl.mira.service.model.match;

public record Head2head
        (int numberOfMatches,
         int totalGoals,
         MatchTeam homeTeam,
         MatchTeam awayTeam) {
}
