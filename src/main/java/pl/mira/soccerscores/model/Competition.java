package pl.mira.soccerscores.model;

import java.util.Date;
import java.util.List;

public record Competition
        (int id,
         Area area,
         String name,
         String code,
         String plan,
         Season currentSeason,
         List<Season> seasons,
         Date lastUpdated) {
}
