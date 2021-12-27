package pl.mira.soccerscores.footballdataclient.model.match;

import pl.mira.soccerscores.footballdataclient.model.Player;
import pl.mira.soccerscores.footballdataclient.model.Team;

public record Goal
        (int minute,
         int extraTime,
         String type,
         Team team,
         Player scorer,
         Player assist) {
}
