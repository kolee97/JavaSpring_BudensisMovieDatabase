package com.company.bmdb;

import com.company.bmdb.domain.Media;
import com.company.bmdb.domain.Review;
import com.company.bmdb.domain.User;
import com.company.bmdb.exceptions.UserNotFoundException;

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
