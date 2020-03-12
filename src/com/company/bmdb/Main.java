package com.company.bmdb;

import com.company.bmdb.domain.User;
import com.company.bmdb.exceptions.UserNotFoundException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        App app = new App(new Service(), new View());
        app.play();
    }
}
