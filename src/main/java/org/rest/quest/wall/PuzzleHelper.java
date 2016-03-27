package org.rest.quest.wall;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Logger;

/**
 * trying to overcome first wall (motto controller)
 */
public class PuzzleHelper {

    public static final Logger logger = Logger.getLogger(PuzzleHelper.class.getSimpleName());

    public int readPuzzleHeader(String hostUrl, String keyword, int teamId, int index, String header) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity entity = Utils.getHttpHeadersEntity(keyword, teamId);

        HttpEntity<String> puzzleResponseEntity = restTemplate.exchange(
                hostUrl + "puzzle/" + index, HttpMethod.GET, entity, String.class, Collections.emptyMap());
        int resultOfComparison = Integer.parseInt(puzzleResponseEntity.getHeaders().get(header).get(0));
        return resultOfComparison;
    }


}
