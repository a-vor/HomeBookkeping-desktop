package com.company.models;

import java.util.ArrayList;

public class User {
    private int id;

    private String login, password, name;

    private ArrayList<String> scoresList;

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.scoresList = new ArrayList<String>();
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.scoresList = new ArrayList<String>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScoresList(String title) {
        this.scoresList.add(title);
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", scoresList=" + scoresList +
                '}';
    }
}
