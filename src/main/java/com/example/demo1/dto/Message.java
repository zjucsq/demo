package com.example.demo1.dto;

import lombok.Data;

@Data
public class Message {
    private boolean state;
    private String message;
    private String authorizeToken;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorizeToken() {
        return authorizeToken;
    }

    public void setAuthorizeToken(String authorizeToken) {
        this.authorizeToken = authorizeToken;
    }
}
