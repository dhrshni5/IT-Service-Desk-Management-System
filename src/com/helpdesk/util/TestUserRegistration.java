package com.helpdesk.util;

import com.helpdesk.dao.UserDAO;
import com.helpdesk.model.User;

public class TestUserRegistration {

    public static void main(String[] args) {

        User user = new User(
                0, "Dharshini",
                "dharshini@test.com",
                "123456",
                "Employee", null
        );

        UserDAO userDAO = new UserDAO();

        boolean result = userDAO.registerUser(user);

        if (result) {
            System.out.println("User Registered Successfully!");
        } else {
            System.out.println("Registration Failed!");
        }
    }
}