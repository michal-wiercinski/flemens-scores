package pl.mira.soccerscores.model;

import java.util.Date;
import java.util.List;

public class Team {
    private int id;
    private Area area;
    private String name;
    private String shortName;
    private String tla;
    private String crestUrl;
    private String address;
    private String phone;
    private String website;
    private String email;
    private int founded;
    private String clubColors;
    private String venue;
    private List<Player> squad;
    private Date lastUpdated;
}
