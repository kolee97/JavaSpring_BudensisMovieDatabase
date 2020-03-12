package com.company.bmdb;

import com.company.bmdb.domain.Actor;
import com.company.bmdb.domain.Media;
import com.company.bmdb.domain.Review;
import com.company.bmdb.domain.User;
import com.company.bmdb.exceptions.UserNotFoundException;
import com.company.bmdb.exceptions.UserWantsToQuitException;

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
        Boolean endProgram = false;
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
        User newUser = new User();
        System.out.println("You are not registered yet.\n\nPlease select a username:\n");
        newUser.setName(sc.nextLine());
        System.out.println("Email address:\n");
        newUser.setEmail(sc.nextLine());
        System.out.println("Password:\n");
        newUser.setPassword(sc.nextLine());
        // TODO: Use service to save user
        service.saveUser(newUser, users);
        currentUser = newUser;
        System.out.println("Now you're good to go!\n");
    }

    private void doReview() {
        Media chosenMedia = view.printChooseMedia(medias);
        Review userReview = view.printCreateReview(chosenMedia, currentUser);
        service.saveReview(chosenMedia, userReview);
        printReviewAverage(chosenMedia);
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

    // TODO: Add private functions (creatuser, doreview, printreviewaverage)

}
