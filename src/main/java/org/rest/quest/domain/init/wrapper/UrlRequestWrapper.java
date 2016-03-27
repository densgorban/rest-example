package org.rest.quest.domain.init.wrapper;

public class UrlRequestWrapper {

    private String teamUrl;

    public UrlRequestWrapper() {
    }

    public UrlRequestWrapper(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    public String getTeamUrl() {
        return teamUrl;
    }

    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }
}
