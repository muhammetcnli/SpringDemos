package com.atlas.thymeleafdemo.model;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favouriteLang;
    private String lovedOS;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLang() {
        return favouriteLang;
    }

    public void setFavouriteLang(String favouriteLang) {
        this.favouriteLang = favouriteLang;
    }

    public String getLovedOS() {
        return lovedOS;
    }

    public void setLovedOS(String lovedOS) {
        this.lovedOS = lovedOS;
    }
}
