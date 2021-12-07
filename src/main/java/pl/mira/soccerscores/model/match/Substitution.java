package pl.mira.soccerscores.model.match;

import pl.mira.soccerscores.model.Player;
import pl.mira.soccerscores.model.Team;

public record Substitution
        (int minute,
         Team team,
         Player playerOut,
         Player playerIn) {
}
