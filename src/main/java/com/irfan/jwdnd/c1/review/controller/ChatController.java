package com.irfan.jwdnd.c1.review.controller;

import com.irfan.jwdnd.c1.review.model.ChatForm;
import com.irfan.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    // Inject service
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public String getChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());

        return "chat";
    }

    @PostMapping()
    public String postChatMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        this.messageService.addMessage(chatForm);

        // reset form
        chatForm.setMessageText("");

        model.addAttribute("chatMessages", this.messageService.getChatMessages());

        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[]{"Say", "Shout", "Whisper"};
    }

}
