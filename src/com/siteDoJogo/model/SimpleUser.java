package com.siteDoJogo.model;

import java.util.StringJoiner;

public class SimpleUser {
    private static long totalId = 1L;
    private Long id;
    private String login;
    private String password;

    public SimpleUser(String login, String password) {
        this.id = totalId++;
        this.login = login.toLowerCase();
        this.password = password;
    }

    // usar este para criar a partir do DB
    public SimpleUser(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        totalId++;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String write(){
        return id +","+ login +","+ password;
    }

    public String toJSON() {
        return new StringJoiner(", ", "{", "}")
                .add("\"id\":\"" + id + "\"")
                .add("\"login\":\"" + login + "\"")
                .add("\"password\":\"" + password + "\"")
                .toString();
    }
}
