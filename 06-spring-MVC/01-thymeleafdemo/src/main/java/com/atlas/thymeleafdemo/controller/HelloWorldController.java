package com.atlas.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/form")
    public String getForm(){
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @PostMapping("/proccessFormtwo")
    public String letsShout(@RequestParam("studentName") String theName, @RequestParam("studentSurName") String theSurName, Model model){
        String upperName;
        String upperSurName;

        upperName = theName.toUpperCase();
        upperSurName = theSurName.toUpperCase();

        String result = "YO! " + upperName + " " + upperSurName;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
