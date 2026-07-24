package com.helpdesk.util;

import com.helpdesk.dao.UserDAO;
import com.helpdesk.model.User;

public class TestUserLogin {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        User user = userDAO.loginUser(
                "dharshini@test.com",
                "123456"
        );

        if (user != null) {

            System.out.println("Login Successful!");
            System.out.println("Welcome " + user.getName());
            System.out.println("Role: " + user.getRole());

        } else {

            System.out.println("Invalid Email or Password");

        }

    }

}
