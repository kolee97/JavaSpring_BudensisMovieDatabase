package com.company.bmdb;

import com.company.bmdb.domain.User;
import com.company.bmdb.exceptions.UserNotFoundException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        View test = new View();
        try {
            test.readUserData(new ArrayList<User>());
        }
        catch (UserNotFoundException ex) {
            System.out.println("User not found");
        }
    }
}
