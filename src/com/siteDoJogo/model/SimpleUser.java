package com.siteDoJogo.model;

import java.util.StringJoiner;

public class SimpleUser {
    private Long id = 0L;
    private String login;
    private String password;

    public SimpleUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String toJSON() {
        return new StringJoiner(", ", "{", "}")
                .add("\"id\":\"" + id + "\"")
                .add("\"login\":\"" + login + "\"")
                .add("\"password\":\"" + password + "\"")
                .toString();
    }
}
