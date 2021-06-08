package com.irfan.jwdnd.c1.review.controller;

import com.irfan.jwdnd.c1.review.MessageForm;
import com.irfan.jwdnd.c1.review.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        // Instantiate the messageListService
        this.messageListService = messageListService;
    }

    /**
     * we're annotating this argument with @ModelAttribute.
     * This allows us to specify that Spring should add the object to our Model.
     * That means we don't have to add it manually!
     */
    @GetMapping()
    public String lowFive(@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        messageListService.addMessage("Welcome, Grasshopper.");

        // Add new attribute
        model.addAttribute("greetings", this.messageListService.getMessages());

        // return page
        return "home";
    }

    /**
     * we're annotating this argument with @ModelAttribute.
     * This allows us to specify that Spring should add the object to our Model.
     * That means we don't have to add it manually!
     */
    @PostMapping()
    public String highFive(@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        // add new message through the form input
        messageListService.addMessage("We shall now study the " + messageForm.getAdjective() + " " + messageForm.getAnimalName() + " style.");

        // add new attribute
        model.addAttribute("greetings", messageListService.getMessages());

        return "home";
    }
}













