package com.company.bmdb;

import com.company.bmdb.domain.Actor;
import com.company.bmdb.domain.Media;
import com.company.bmdb.domain.Review;
import com.company.bmdb.domain.User;

import javax.accessibility.AccessibleRelation;
import java.util.ArrayList;

public class TestDataBuilder {
    ArrayList<Media> medias;
    ArrayList<Actor> actors;
    ArrayList<User> users;
    ArrayList<Review> reviews;

    public TestDataBuilder(ArrayList<Media> medias, ArrayList<Actor> actors, ArrayList<User> users) {
        this.medias = medias;
        this.actors = actors;
        this.users = users;
        this.reviews = new ArrayList<Review>();
    }

    // TODO: implement array filler functions

    public void Build() {

    }
}
