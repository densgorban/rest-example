package org.rest.quest.domain;

/**
 * @author Roman Uholnikov
 */
public class User {

    private String name;
    private String tribe;
    private String gender;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(final String tribe) {
        this.tribe = tribe;
    }

    public User(final String name, final String tribe, final String gender) {
        this.name = name;
        this.tribe = tribe;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                ", tribe='" + tribe + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
