package org.rest.quest.wall;

import org.rest.quest.domain.init.wrapper.MottoComparisonWrapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Created by roman on 19.03.16.
 */
public class Utils {

    private Utils() {
    }

    public static HttpEntity getHttpHeadersEntity(String keyword, int teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("team-id", String.valueOf(teamId));
        headers.set("keyword", keyword);
        return new HttpEntity(headers);
    }

    public static HttpEntity getJSONHttpHeadersEntity(String keyword, int teamId, MottoComparisonWrapper wrapper) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("team-id", String.valueOf(teamId));
        headers.set("keyword", keyword);
        headers.set("Content-Type", "application/json");
        return new HttpEntity(wrapper,headers);
    }
}
