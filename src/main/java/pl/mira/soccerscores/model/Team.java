package pl.mira.soccerscores.model;

import java.util.Date;
import java.util.List;

public record Team
        (int id,
         Area area,
         String name,
         String shortName,
         String tla,
         String crestUrl,
         String address,
         String phone,
         String website,
         String email,
         int founded,
         String clubColors,
         String venue,
         List<Player> squad,
         Date lastUpdated) {
}
