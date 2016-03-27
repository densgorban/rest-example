package org.rest.quest.domain.init.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MessageWrapper {

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String keyword;

    public MessageWrapper() {
    }

    public MessageWrapper(String message) {
        this.message = message;
    }

    public MessageWrapper(String message, String keyword) {
        this.message = message;
        this.keyword = keyword;
    }

    public String getMessage() {
        return message;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" +
                "message='" + message + '\'' +
                '}';
    }
}
