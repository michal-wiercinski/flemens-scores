package pl.mira.footballdataclient.control;

import org.springframework.stereotype.Service;
import pl.mira.soccerscores.footballdataclient.entity.request.CompetitionMatchRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ParametersMapper {

    public Map<String, String> getCompetitionMatchRequestMap(CompetitionMatchRequest competitionMatchRequest) {
        Map<String, String> vars = new HashMap<>();

        Optional.of(competitionMatchRequest)
                .map(CompetitionMatchRequest::dateFrom)
                .ifPresentOrElse(date -> {
                            vars.put("dateFrom", date.toString());
                        },
                        () -> {
                            vars.put("dateFrom", "");
                        });

        Optional.of(competitionMatchRequest)
                .map(CompetitionMatchRequest::dateTo)
                .ifPresentOrElse(date -> {
                            vars.put("dateTo", date.toString());
                        },
                        () -> {
                            vars.put("dateTo", "");
                        });

        Optional.of(competitionMatchRequest)
                .map(CompetitionMatchRequest::statusEnum)
                .ifPresentOrElse(statusEnum -> {
                            vars.put("status", statusEnum.toString());
                        },
                        () -> {
                            vars.put("status", "");
                        });

        Optional.of(competitionMatchRequest)
                .map(CompetitionMatchRequest::matchDay)
                .ifPresentOrElse(matchDay -> {
                            vars.put("matchday", String.valueOf(competitionMatchRequest.matchDay()));
                        },
                        () -> {
                            vars.put("matchday", "");
                        });

        Optional.of(competitionMatchRequest)
                .map(CompetitionMatchRequest::seasonYear)
                .ifPresentOrElse(seasonYear -> {
                            vars.put("season", String.valueOf(competitionMatchRequest.seasonYear()));
                        },
                        () -> {
                            vars.put("season", "");
                        });
        return vars;
    }
}
