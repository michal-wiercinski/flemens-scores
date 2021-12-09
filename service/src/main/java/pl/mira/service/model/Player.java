package pl.mira.service.model;

import java.util.Date;

public record Player
    (int id,
    String name,
    String position,
    Date dateOfBirth,
    String countryOfBirth,
    String nationality,
    String role) {
}