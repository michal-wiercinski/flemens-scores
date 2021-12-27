package pl.mira.soccerscores.footballdataclient.model.match;

import pl.mira.soccerscores.footballdataclient.model.Competition;
import pl.mira.soccerscores.footballdataclient.model.Season;

import java.util.Date;
import java.util.List;

public record Match
        (int id,
         Competition competition,
         Season season,
         Date utcDate,
         String status,
         int minute,
         int attendance,
         String venue,
         int matchday,
         String stage,
         String group,
         Date lastUpdated,
         MatchTeam homeTeam,
         MatchTeam awayTeam,
         Score score,
         List<Goal> goals,
         List<Booking> bookings,
         List<Substitution> substitutions,
         List<Referee> referees) {
}
