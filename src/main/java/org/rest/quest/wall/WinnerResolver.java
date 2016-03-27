package org.rest.quest.wall;

import org.rest.quest.domain.init.wrapper.UrlRequestWrapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

/**
 * Created by r.uholnikov on 26.03.2016.
 */
public class WinnerResolver {

    public static int TEAM_ID;
    public static String HOST_URL;
    public static String KEYWORD;

    public static void sendWinnerUrl(String hostUrl, String keyword, int teamId) throws UnknownHostException {
        HOST_URL = hostUrl;
        TEAM_ID = teamId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("team-id", String.valueOf(teamId));
        headers.add("keyword", keyword);
        headers.add("Content-Type", "application/json");
        String urlRequest = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8081";
        HttpEntity entity = new HttpEntity(new UrlRequestWrapper(urlRequest), headers);


        HttpEntity<String> puzzleResponseEntity = restTemplate.exchange(
                hostUrl + "winners", HttpMethod.POST, entity, String.class, Collections.emptyMap());
    }
}
