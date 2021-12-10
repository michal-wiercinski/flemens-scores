package pl.mira.soccerscores.model.match;

import lombok.Getter;
import lombok.Setter;
import pl.mira.soccerscores.model.Competition;
import pl.mira.soccerscores.model.Season;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Match {
        private int id;
         private Competition competition;
         private Season season;
         private Date utcDate;
         private String status;
         private int minute;
         private int attendance;
         private String venue;
         private int matchday;
         private String stage;
         private String group;
         private Date lastUpdated;
         private MatchTeam homeTeam;
         private MatchTeam awayTeam;
         private Score score;
         private List<Goal> goals;
         private List<Booking> bookings;
         private List<Substitution> substitutions;
         private List<Referee> referees;
}
