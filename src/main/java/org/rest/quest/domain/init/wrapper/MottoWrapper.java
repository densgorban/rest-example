package org.rest.quest.domain.init.wrapper;

/**
 * Created by r.uholnikov on 27.03.2016.
 */
public class MottoWrapper {
    int id;
    String motto;

    public MottoWrapper() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }


    @Override
    public String toString() {
        return "MottoWrapper{" +
                "id=" + id +
                ", motto='" + motto + "'}";
    }
}
