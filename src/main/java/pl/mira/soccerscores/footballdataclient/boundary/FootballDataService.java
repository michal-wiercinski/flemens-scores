package pl.mira.soccerscores.footballdataclient.boundary;

import org.springframework.stereotype.Service;
import pl.mira.soccerscores.footballdataclient.control.RestClient;
import pl.mira.soccerscores.footballdataclient.entity.request.CompetitionMatchRequest;
import pl.mira.soccerscores.footballdataclient.entity.response.BasicCompetitionMatchResponse;

@Service
public class FootballDataService {

    public FootballDataService(RestClient restClient) {
        this.restClient = restClient;
    }

    private final RestClient restClient;
    
    
    public BasicCompetitionMatchResponse getAllMatchFromToday() {
        return restClient.getMatchesSimpleRequest();
    }

    public BasicCompetitionMatchResponse getBasicCompetitionMatchResponse(CompetitionMatchRequest competitionMatchRequest) {
        return  restClient.getBasicCompetitionMatchesRequest(competitionMatchRequest);
    }
}
