package com.thonglam.jmsdemo.model;

import java.io.Serializable;

public class MessagePayload implements Serializable {
    private String id;
    private String content;

    // Constructors
    public MessagePayload() {}

    public MessagePayload(String id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "MessagePayload{id='" + id + "', content='" + content + "'}";
    }
}