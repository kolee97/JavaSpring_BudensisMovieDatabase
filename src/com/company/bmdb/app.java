package com.company.bmdb;

import com.company.bmdb.domain.Actor;
import com.company.bmdb.domain.Media;
import com.company.bmdb.domain.Review;
import com.company.bmdb.domain.User;

import java.util.ArrayList;

public class app {
    private ArrayList<User> users;
    private Review review;
    private ArrayList<Media> medias;
    private ArrayList<Actor> actors;
    private Media selectedMedia;

    private Service service;
    private View view;

    public app(Service service, View view) {
        this.service = service;
        this.view = view;
    }

    public void play() {
        init();
        view.readUserData(users);
    }

    private void init() {
        TestDataBuilder builder = new TestDataBuilder(medias, actors, users);
        builder.Build();
    }

    private void

}
