package com.example.service;

import com.example.service.exceptions.UserNotFoundException;
import com.example.domain.Media;
import com.example.domain.Review;
import com.example.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public void saveUser(User user, ArrayList<User> users) {
        users.add(user);
    }

    public User findUser(String userName, ArrayList<User> users) {
        for (User user : users
             ) {
            if (userName.equals(user))
                return user;
        }
        throw new UserNotFoundException();
    }

    public List<Media> findAllMedia(ArrayList<Media> medias) {
        return medias;
    }

    public void saveReview(Media media, Review review) {
        media.reviews.add(review);
    }

    public List<Review> findAllReview(Media media) {
        return media.reviews;
    }
}
