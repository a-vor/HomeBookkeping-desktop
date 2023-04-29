package com.company;
import com.company.models.User;
import com.company.services.Registration;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        try {
            Connection connection = db.getConnection();
            User user = new User();
            Registration registration = new Registration();
            registration.register(user, connection);
        } catch (SQLException e) {
            System.out.println("Problem");
            e.getMessage();
        }
    }
}