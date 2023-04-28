package com.company.services;

import com.company.Database;
import com.company.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Auth {
    private final int MAX_ATTEMPT = 3;
//    public User authorization(Database db) {
//        User candidate = new User();
//        int candidateId = getLoginId(candidate, db);
//        if (candidateId != -1) {
//            System.out.println("dsfl;");
//        }
//        return null;
//    }

//    private int getLoginId(User candidate, Database db) {
//        for (User obj : db.getUsers()) {
//            if (candidate.getLogin().equals(obj.getLogin())) {
//                System.out.println("!!!");
//                return db.getUsers().indexOf(obj);
//            }
//        }
//        return -1;
//    }
//
//    private boolean isCorrectPassword(User candidate, Database db, int loginId) {
//        return db.getUsers().get(loginId).getPassword().equals(candidate.getPassword());
//    }


}
