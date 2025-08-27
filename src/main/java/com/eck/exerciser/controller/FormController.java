package com.eck.exerciser.controller;

import com.eck.exerciser.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {


    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }


    @PostMapping("/add-student")
    public String submitForm(@ModelAttribute Student student, Model model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("surname", student.getSurname());
        return "result";
    }
}
