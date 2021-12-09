package pl.mira.service.model.match;

import pl.mira.soccerscores.model.Player;
import pl.mira.soccerscores.model.Team;

public record Goal
        (int minute,
         int extraTime,
         String type,
         Team team,
         Player scorer,
         Player assist) {
}
