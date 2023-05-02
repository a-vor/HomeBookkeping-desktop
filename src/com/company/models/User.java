package com.company.models;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private int id;

    private String login, password, name, role;

    public ArrayList<String> scores = new ArrayList<String>();

    public User() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login");
        this.setLogin(scanner.nextLine());
        System.out.println("Enter your name");
        this.setName(scanner.nextLine());
        System.out.println("Enter password");
        this.setPassword(scanner.nextLine());
    }

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setScores(ArrayList<String> scores) {
        this.scores.addAll(scores);
    }

    public boolean setScores(String score) {
        return this.scores.add(score) ? true : false;
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
                ", role='" + role + '\'' +
                ", scores=" + scores +
                '}';
    }
}
