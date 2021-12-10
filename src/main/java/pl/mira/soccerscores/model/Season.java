package pl.mira.soccerscores.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Season {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int currentMatchday;
}