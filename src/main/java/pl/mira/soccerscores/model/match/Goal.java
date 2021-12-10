package pl.mira.soccerscores.model.match;

import pl.mira.soccerscores.model.Player;
import pl.mira.soccerscores.model.Team;

public class Goal {
    private int minute;
    private int extraTime;
    private String type;
    private Team team;
    private Player scorer;
    private Player assist;
}
