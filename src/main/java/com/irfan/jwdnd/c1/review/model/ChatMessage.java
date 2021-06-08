package com.irfan.jwdnd.c1.review.model;

// This class is used for displaying chat
// like John: Hello, world!
public class ChatMessage {

    private String username;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
