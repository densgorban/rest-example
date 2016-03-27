package org.rest.quest.wall;

import org.rest.quest.domain.init.wrapper.MottoComparisonWrapper;
import org.rest.quest.domain.init.wrapper.MottoWrapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;

/**
 * trying to overcome first wall (motto controller)
 */
public class MottoHelper {

    public static final Logger logger = Logger.getLogger(MottoHelper.class.getSimpleName());

    public MottoWrapper getKeyword(String hostUrl, String keyword, int teamId, int index){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity entity = Utils.getHttpHeadersEntity(keyword, teamId);

        HttpEntity<MottoWrapper> mottoWrapperResponseEntity = restTemplate.exchange(
                hostUrl + "motto/" + index, HttpMethod.GET, entity, MottoWrapper.class, Collections.emptyMap());

        MottoWrapper mottoWrapper = mottoWrapperResponseEntity.getBody();
        logger.info(mottoWrapper.getMotto().toString());

        return mottoWrapper;
    }


    public static int compareKeyword(String hostUrl, String keyword, int teamId, MottoWrapper moto0, MottoWrapper moto1){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity entity = Utils.getJSONHttpHeadersEntity(keyword, teamId);

        HashMap<String, Integer> bodyMap = new HashMap<>();
        bodyMap.put(moto0.getMotto(), moto0.getId());
        bodyMap.put(moto1.getMotto(), moto1.getId());
        HttpEntity<String> mottoWrapperResponseEntity = restTemplate.exchange(
                hostUrl + "motto", HttpMethod.POST, entity, String.class, bodyMap);

        logger.info(mottoWrapperResponseEntity.getBody());

        return Integer.parseInt(mottoWrapperResponseEntity.getBody());
    }




}
