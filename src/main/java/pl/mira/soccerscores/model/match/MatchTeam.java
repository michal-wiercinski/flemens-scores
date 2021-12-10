package pl.mira.soccerscores.model.match;

import lombok.Getter;
import lombok.Setter;
import pl.mira.soccerscores.model.Player;

import java.util.List;

@Getter
@Setter
public class MatchTeam {
    private int wins;
    private int draws;
    private int losses;
    private int id;
    private String name;
    private Coach coach;
    private Player captain;
    private List<Player> lineup;
    private List<Player> benchl;
}