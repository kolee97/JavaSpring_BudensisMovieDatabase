package com.company.bmdb;

import com.company.bmdb.domain.*;
import com.company.bmdb.exceptions.MediaNotFoundException;
import com.company.bmdb.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    // throws UserNotFoundException
    public User readUserData(List<User> users) {
        System.out.println("What is your name?");

        String userName = sc.nextLine();

        for (User user : users) {
            if (userName.equals(user.getName())) {
                return user;
            }
        }

        throw new UserNotFoundException();
    }

    public void printWelcomeMessage(User user) {
        System.out.println(
                "Welcome to the movie and series review application, "
                + user.getName() + "!");
    }

    public void printMedias(ArrayList<Media> medias) {
        StringBuilder sb = new StringBuilder();
        for (Media media : medias) {
            sb.append(media.getId() + ":" + media.getTitle() + "\n");
            sb.append(String.format("Description=%s\n", media.getDescription()));
            sb.append(String.format("Premier=%s\n", media.getPremier().toString()));
            sb.append("Actors:\n");
            for (Actor actor : media.cast) {
                sb.append(String.format("\t%s", actor.getName()));
            }
            sb.append("\nReviews:\n");
            for (Review review : media.reviews) {
                sb.append(String.format("\t%s\n\t%s\n", review.getText(), review.getRating().toString()));
            }
            sb.append("\n\n");
        }
        System.out.println(sb.toString());
    }

    public void printReviews(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("Current user\'s reviews:\n\n");
        for (Review review : user.reviews
             ) {
            sb.append(String.format("\tText:%s\nRating:%s\n", review.getText(), review.getRating().toString()));
        }
        System.out.println(sb.toString());
    }

    public Media printChooseMedia(ArrayList<Media> medias) {
        System.out.println("Choose an id.");
        return findMedia(Integer.parseInt(sc.nextLine()), medias);
    }

    public Review printCreateReview(Media media, User currentUser) {
        Review res = new Review();

        System.out.println("Write a review.");
        res.setText(sc.nextLine());
        System.out.println("Choose a rating! (BAD/GOOD/AVERAGE)");
        res.setRating(convertRating(sc.nextLine()));
        res.setMedia(media);
        res.setCreator(currentUser);

        return res;
    }

    public boolean printContinue() {
        System.out.println("Do you want to write another review? (yes/no)");
        String ans = sc.nextLine();
        if (ans.toLowerCase().equals("yes"))
            return true;
        else
            return false;
    }

    private Rating convertRating(String rating) {
        switch (rating.toLowerCase()) {
            case "bad":
                return Rating.BAD;
            case "average":
                return Rating.AVERAGE;
            case "good":
                return Rating.GOOD;
            default:
                return Rating.AVERAGE;
        }
    }

    private Media findMedia(int id, ArrayList<Media> medias) {
        for (Media media : medias
             ) {
            if (media.getId() == id)
                return media;
        }
        throw new MediaNotFoundException();
    }
}
