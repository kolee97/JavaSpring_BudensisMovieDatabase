package com.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Media {
    private long id;
    private String title;
    private String description;
    private LocalDate premier;

    public ArrayList<Review> reviews;
    public ArrayList<Actor> cast;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPremier() {
        return premier;
    }

    public void setPremier(LocalDate premier) {
        this.premier = premier;
    }


}
