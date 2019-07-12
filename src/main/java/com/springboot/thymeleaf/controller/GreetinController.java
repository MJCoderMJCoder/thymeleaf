package com.springboot.thymeleaf.controller;

import com.springboot.thymeleaf.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sun.rmi.runtime.Log;

@Controller
public class GreetinController {
    /**
     * The greetingForm() method uses a Model object to expose a new Greeting to the view template.
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String greetingForm(Model model) {
        System.out.println("greetingForm：" + model);
        model.addAttribute("greeting", new Greeting());
        System.out.println("greetingForm：" + model);
        return "greeting"; //greeting.html
    }

    /**
     * The Greeting is a @ModelAttribute so it is bound to the incoming form content,
     * and also the submitted data can be rendered in the result view by referring to it by name (the name of the method parameter by default,
     * so "greeting" in this case).
     *
     * @param greeting
     * @return
     */
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        System.out.println("greetingSubmit：" + greeting);
        return "result"; //result.html
    }
}
