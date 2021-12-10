package pl.mira.soccerscores.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Competition {
    private int id;
    private Area area;
    private String name;
    private String code;
    private String plan;
    private Season currentSeason;
    private List<Season> seasons;
    private Date lastUpdated;
}
