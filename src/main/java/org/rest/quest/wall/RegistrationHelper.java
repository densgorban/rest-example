package org.rest.quest.wall;

import org.rest.quest.domain.Team;
import org.rest.quest.domain.init.wrapper.MessageWrapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by roman on 19.03.16.
 */
public class RegistrationHelper {

    public static final Logger logger = Logger.getLogger(RegistrationHelper.class.getSimpleName());


    public void registerTeam(String hostUrl, String teamName, String teamMotto){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        Team team =new Team();
        team.setName(teamName);
        team.setMotto(teamMotto);
        team.setMembers(Arrays.asList("Rostik", "Dima", "Marina", "Denis"));

        MessageWrapper registrationMessageWrapper = restTemplate.postForObject(hostUrl + "/teams", team, MessageWrapper.class);
        logger.info("received response: " + registrationMessageWrapper.getMessage());
    }
}
