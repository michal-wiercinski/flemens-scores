package pl.mira.soccerscores.footballdataclient.model.match;

import pl.mira.soccerscores.footballdataclient.model.Player;
import pl.mira.soccerscores.footballdataclient.model.Team;

public record Substitution
        (int minute,
         Team team,
         Player playerOut,
         Player playerIn) {
}
