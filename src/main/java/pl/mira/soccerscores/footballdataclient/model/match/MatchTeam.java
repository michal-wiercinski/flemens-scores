package pl.mira.soccerscores.footballdataclient.model.match;

import pl.mira.soccerscores.footballdataclient.model.Player;

import java.util.List;

public record MatchTeam
        (int wins,
         int draws,
         int losses,
         int id,
         String name,
         Coach coach,
         Player captain,
         List<Player> lineup,
         List<Player> bench) {
}