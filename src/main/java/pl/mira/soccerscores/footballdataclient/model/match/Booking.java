package pl.mira.soccerscores.footballdataclient.model.match;

import pl.mira.soccerscores.footballdataclient.model.Player;
import pl.mira.soccerscores.footballdataclient.model.Team;

public record Booking
        (int minute,
         Team team,
         Player player,
         String card) {
}
