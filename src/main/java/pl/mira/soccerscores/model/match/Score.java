package pl.mira.soccerscores.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
        private String winner;
        private String duration;
        private Result fullTime;
        private Result halfTime;
        private Result extraTime;
        private Result penalties;
}
