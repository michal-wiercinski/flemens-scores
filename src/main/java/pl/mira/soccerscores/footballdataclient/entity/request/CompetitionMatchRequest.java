package pl.mira.soccerscores.footballdataclient.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mira.soccerscores.model.enums.StatusEnum;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionMatchRequest {
    private String competitionCode;
    private Integer seasonYear;
    private StatusEnum statusEnum;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer matchDay;
}
