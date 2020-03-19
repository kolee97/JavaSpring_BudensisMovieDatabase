package com.example.app;

import com.example.service.App;
import com.example.service.Service;

public class Main {

    public static void main(String[] args) {
        App app = new App(new Service(), new View());
        app.play();
    }
}
