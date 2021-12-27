package pl.mira.soccerscores.footballdataclient.model.match;

public record Score
        (String winner,
         String duration,
         Result fullTime,
         Result halfTime,
         Result extraTime,
         Result penalties) {
}
