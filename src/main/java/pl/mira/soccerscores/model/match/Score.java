package pl.mira.soccerscores.model.match;

public record Score
        (String winner,
         String duration,
         Result fullTime,
         Result halfTime,
         Result extraTime,
         Result penalties) {
}
