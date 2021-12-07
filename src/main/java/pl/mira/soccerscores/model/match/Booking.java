package pl.mira.soccerscores.model.match;

import pl.mira.soccerscores.model.Player;
import pl.mira.soccerscores.model.Team;

public record Booking
        (int minute,
         Team team,
         Player player,
         String card) {
}
