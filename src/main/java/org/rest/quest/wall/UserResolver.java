package org.rest.quest.wall;

import org.rest.quest.domain.User;
import org.rest.quest.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * trying to overcome first wall (motto controller)
 */
public class UserResolver {

    public static final Logger logger = Logger.getLogger(UserResolver.class.getSimpleName());

    public void readUser(String hostUrl, String keyword, int teamId){
        List<User> users = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity entity = Utils.getHttpHeadersEntity(keyword, teamId);

        HttpEntity<List> puzzleResponseEntity = restTemplate.exchange(
                hostUrl + "users", HttpMethod.GET, entity, List.class, Collections.emptyMap());

        logger.info("count of users: " + puzzleResponseEntity.getBody().size());
        users.stream().forEach(user -> logger.info(user.getName()));
    }



}
