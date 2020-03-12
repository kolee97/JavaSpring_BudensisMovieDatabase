package com.company.bmdb;

import com.company.bmdb.domain.Media;
import com.company.bmdb.domain.User;
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
            if (userName == user.getName()) {
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
            // TODO: Finish the printing methods
        }
    }
}
