package pl.mira.footballdataclient.control;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mira.soccerscores.footballdataclient.entity.request.CompetitionMatchRequest;
import pl.mira.soccerscores.footballdataclient.entity.response.CompetitionMatchResponse;
import pl.mira.soccerscores.model.Competition;

import java.util.Map;

@Service
public class RestClient {

    private final RestTemplate restTemplate;
    private final ParametersMapper parametersMapper;

    public RestClient(RestTemplateBuilder builder, ParametersMapper parametersMapper) {
        this.restTemplate = builder.build();
        this.parametersMapper = parametersMapper;
    }

    public Competition getCompetitionById(Integer id) {
        HttpEntity httpEntity = getHttpEntity();

        return restTemplate.exchange(getBasicUrl() + "competitions/{id}",
                        HttpMethod.GET,
                        httpEntity,
                        new ParameterizedTypeReference<Competition>() {
                        },
                        id)
                .getBody();

    }

    public CompetitionMatchResponse getMatchesByCompetitionMatchRequest(CompetitionMatchRequest competitionMatchRequest) {
        HttpEntity httpEntity = getHttpEntity();

        Map<String, String> vars = parametersMapper.getCompetitionMatchRequestMap(competitionMatchRequest);

        return restTemplate.exchange(getCompetitionMatchRequestUrl(competitionMatchRequest),
                        HttpMethod.GET,
                        httpEntity,
                        new ParameterizedTypeReference<CompetitionMatchResponse>() {
                        },
                        vars)
                .getBody();
    }

    private String getCompetitionMatchRequestUrl(CompetitionMatchRequest competitionMatchRequest) {
        return getBasicUrl() + "competitions/" + competitionMatchRequest.competitionCode() + "/matches?" +
                "dateFrom={dateFrom}&dateTo={dateTo}&status={status}&matchday={matchday}&season={season}";
    }

    private String getBasicUrl() {
        return "https://api.football-data.org/v2/";
    }

    private HttpEntity getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Auth-Token", "c41237120abc447da4d7ff84e3f1e4bb");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return httpEntity;
    }
}
