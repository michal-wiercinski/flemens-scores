package pl.mira.service.model;

import java.time.LocalDate;

public record Season
        (int id,
         LocalDate startDate,
         LocalDate endDate,
         int currentMatchday) {
}