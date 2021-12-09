package pl.mira.footballdataclient.entity.request;

import pl.mira.soccerscores.model.enums.StatusEnum;

import java.time.LocalDate;

public record CompetitionMatchRequest
        (String competitionCode,
         Integer seasonYear,
         StatusEnum statusEnum,
         LocalDate dateFrom,
         LocalDate dateTo,
         Integer matchDay) {
}
