package com.atlas.thymeleafdemo.controller;

import com.atlas.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${ops}")
    private List<String> os;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create new student object
        Student tempStudent = new Student();
        // add student object to the model
        theModel.addAttribute("student", tempStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("ops", os);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
