package com.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Actor {
    private String name;
    private LocalDate born;
    private Sex sex;
    private String biography;
    ArrayList<Media> filmography;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
