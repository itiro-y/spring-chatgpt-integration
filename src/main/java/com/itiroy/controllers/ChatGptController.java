package com.itiroy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itiroy.services.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @GetMapping("/chat")
    public Object chat(@RequestParam("prompt") String prompt) throws JsonProcessingException {
        return chatGptService.chat(prompt);
    }
}
