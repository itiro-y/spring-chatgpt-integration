package com.itiroy.services;

import com.itiroy.vo.request.ChatGptRequest;
import com.itiroy.vo.response.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.logging.Logger;

@Service
public class ChatGptService implements Serializable {
    private static final long serialVersionUID = 1L;
    private Logger logger = Logger.getLogger(ChatGptResponse.class.getName());

    @Value("openai.model")
    private String model;

    @Value("openai.api.url")
    private String url;

    @Autowired
    private RestTemplate template;

    public Object chat(String prompt){
        logger.info("Starting chat with prompt: " + prompt);
        ChatGptRequest request = new ChatGptRequest(model, prompt);

        logger.info("Processing prompt...");
        ChatGptResponse response = template.postForObject(url, request, ChatGptResponse.class);

        return response;
    }
}
