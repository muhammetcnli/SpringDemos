package com.springdemo.mvc;


import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required.")
    @Size(min = 1, message = "is required.")
    private String lastName;

    @NotNull(message = "is required.")
    @Min(value = 0, message = "Must be greater than or equal to 0.")
    @Max(value = 10, message = "Must be less than or equal to 10.")
    private Integer freePasses;

    // regex code for email
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Enter correct email.")
    private String email;

    @CourseCode(value="LUV", message="Must start with LUV.")
    private String courseCode;


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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
