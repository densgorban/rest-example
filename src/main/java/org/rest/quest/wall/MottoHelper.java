package org.rest.quest.wall;

import org.rest.quest.domain.Puzzle;
import org.rest.quest.domain.init.wrapper.MottoComparisonWrapper;
import org.rest.quest.domain.init.wrapper.MottoWrapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;

/**
 * trying to overcome first wall (motto controller)
 */
public class MottoHelper {

    public static final Logger logger = Logger.getLogger(MottoHelper.class.getSimpleName());
    public static int TEAM_ID;
    public static String HOST_URL;

    public static MottoWrapper getKeyword(String keyword, int index){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity entity = Utils.getHttpHeadersEntity(keyword, TEAM_ID);

        HttpEntity<MottoWrapper> mottoWrapperResponseEntity = restTemplate.exchange(
                HOST_URL + "motto/" + index, HttpMethod.GET, entity, MottoWrapper.class, Collections.emptyMap());

        MottoWrapper mottoWrapper = mottoWrapperResponseEntity.getBody();
        logger.info(mottoWrapper.getMotto());

        return mottoWrapper;
    }


    public static int compareKeyword(String keyword, MottoWrapper moto0, MottoWrapper moto1){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        MottoComparisonWrapper wrapper = new MottoComparisonWrapper(moto0.getId(), moto1.getId());

        HttpEntity entity = Utils.getJSONHttpHeadersEntity(keyword, TEAM_ID, wrapper);

        HttpEntity<String> mottoWrapperResponseEntity = restTemplate.exchange(
                HOST_URL + "motto/", HttpMethod.POST, entity, String.class, Collections.EMPTY_LIST);

        logger.info(mottoWrapperResponseEntity.getBody());

        return Integer.parseInt(mottoWrapperResponseEntity.getBody());
    }

    public static HttpEntity<Puzzle> getPazzle(String keyword, int index){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity entity = Utils.getHttpHeadersEntity(keyword, MottoHelper.TEAM_ID);

        HttpEntity<Puzzle> pazzleWrapperResponseEntity = restTemplate.exchange(
                HOST_URL + "puzzle/" + index, HttpMethod.GET, entity, Puzzle.class, Collections.EMPTY_LIST);

        logger.info(pazzleWrapperResponseEntity.getBody().toString());

        return pazzleWrapperResponseEntity;
    }



}
