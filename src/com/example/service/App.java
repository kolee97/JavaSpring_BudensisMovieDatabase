package com.example.service;

import com.example.domain.Actor;
import com.example.service.exceptions.UserNotFoundException;
import com.example.service.exceptions.UserWantsToQuitException;
import com.example.app.View;
import com.example.domain.Media;
import com.example.domain.Review;
import com.example.domain.User;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private ArrayList<User> users;
    private Review review;
    private ArrayList<Media> medias;
    private ArrayList<Actor> actors;
    private Media selectedMedia;
    private User currentUser;

    private Service service;
    private View view;

    public App(Service service, View view) {
        this.service = service;
        this.view = view;

        this.users = new ArrayList<User>();
        this.medias = new ArrayList<Media>();
        this.actors = new ArrayList<Actor>();
    }

    public void play() {
        init();
        try {
            currentUser = view.readUserData(users);
        }
        catch (UserNotFoundException ex) {
            createUser();
        }
        view.printWelcomeMessage(currentUser);
        boolean endProgram = false;
        do {
            view.printMedias(medias);
            try {
                doReview();
            }
            catch (UserWantsToQuitException ex) {
                endProgram = true;
            }
        } while(!endProgram);
    }

    private void init() {
        TestDataBuilder builder = new TestDataBuilder(medias, actors, users);
        builder.Build();
    }

    private void createUser() {
        Scanner sc = new Scanner(System.in);
        User newUser = view.getUserDetails();
        service.saveUser(newUser, users);
        currentUser = newUser;
    }

    private void doReview() {
        selectedMedia = view.printChooseMedia(medias);
        review = view.printCreateReview(selectedMedia, currentUser);
        service.saveReview(selectedMedia, review);
        printReviewAverage(selectedMedia);
        if (!view.printContinue()) {
            throw new UserWantsToQuitException();
        }
    }

    private void printReviewAverage(Media media) {
        double avg = 0.0;

        for (Review review : media.reviews
             ) {
            avg += review.getRating().rate;
        }

        avg /= media.reviews.size();

        System.out.println(String.format("Average of reviews: %s", avg));
    }
}
