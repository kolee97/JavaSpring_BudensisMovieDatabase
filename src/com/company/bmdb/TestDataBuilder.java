package com.company.bmdb;

import com.company.bmdb.domain.*;

import javax.accessibility.AccessibleRelation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestDataBuilder {
    ArrayList<Media> medias;
    ArrayList<Actor> actors;
    ArrayList<User> users;

    public TestDataBuilder(ArrayList<Media> medias, ArrayList<Actor> actors, ArrayList<User> users) {
        this.medias = medias;
        this.actors = actors;
        this.users = users;
    }

    private void addMedias() {

        Movie m1 = new Movie();
        m1.setDescription("testDescription1");
        m1.setId(1);
        m1.setPremier(LocalDate.parse("2000-01-01"));
        m1.setTitle("testTitle1");
        m1.cast = new ArrayList<Actor>();
        m1.reviews = new ArrayList<Review>();

        Movie m2 = new Movie();
        m2.setDescription("testDescription2");
        m2.setId(2);
        m2.setPremier(LocalDate.parse("2000-01-01"));
        m2.setTitle("testTitle2");
        m2.cast = new ArrayList<Actor>();
        m2.reviews = new ArrayList<Review>();

        Movie m3 = new Movie();
        m3.setDescription("testDescription3");
        m3.setId(3);
        m3.setPremier(LocalDate.parse("2000-01-01"));
        m3.setTitle("testTitle3");
        m3.cast = new ArrayList<Actor>();
        m3.reviews = new ArrayList<Review>();

        Series s1 = new Series();
        s1.setDescription("testDescription4");
        s1.setId(4);
        s1.setPremier(LocalDate.parse("2000-01-01"));
        s1.setTitle("testTitle4");
        s1.cast = new ArrayList<Actor>();
        s1.reviews = new ArrayList<Review>();

        Series s2 = new Series();
        s2.setDescription("testDescription5");
        s2.setId(5);
        s2.setPremier(LocalDate.parse("2000-01-01"));
        s2.setTitle("testTitle5");
        s2.cast = new ArrayList<Actor>();
        s2.reviews = new ArrayList<Review>();

        medias.add(m1);
        medias.add(m2);
        medias.add(m3);
        medias.add(s1);
        medias.add(s2);
    }

    private void addActors() {
        int iterator = 1;
        for (Media media : medias
             ) {
            Actor actor1 = new Actor();
            Actor actor2 = new Actor();
            actor1.setName("tesztActor" + iterator++);
            actor2.setName("tesztActor" + iterator++);
            media.cast.add(actor1);
            media.cast.add(actor2);
        }
    }

    private void addUsers() {
        for (int i = 1; i < 4; i++) {
            User u = new User();
            u.setName("tesztUser" + i);
            users.add(u);
        }
    }

    private void addReviews() {
        int iter = 1;
        for (Media media : medias
             ) {
            Review r1 = new Review();
            r1.setCreator(users.get(0));
            r1.setMedia(media);
            r1.setRating(Rating.AVERAGE);
            r1.setText(String.format("This is a review. (#%s)", String.valueOf(iter++)));

            Review r2 = new Review();
            r2.setCreator(users.get(1));
            r2.setMedia(media);
            r2.setRating(Rating.GOOD);
            r2.setText(String.format("This is a review. (#%s)", String.valueOf(iter++)));

            media.reviews.add(r1);
            media.reviews.add(r2);
        }
    }

    public void Build() {
        addMedias();
        addActors();
        addUsers();
        addReviews();
    }
}
