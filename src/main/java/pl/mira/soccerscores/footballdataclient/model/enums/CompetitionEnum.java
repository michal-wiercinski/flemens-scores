package pl.mira.soccerscores.footballdataclient.model.enums;

public enum CompetitionEnum {
    PREMIER_LEAGUE("PL", 2021);

    private final String code;
    private final int id;

    CompetitionEnum(String code, int id) {
        this.code = code;
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }
}
