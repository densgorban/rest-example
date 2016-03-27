package org.rest.quest.domain;

import java.util.List;

/**
 * @author Roman Uholnikov
 */
public class Team {


    private String name;

    private String motto;

    private List<String> members;

    public Team() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

}
