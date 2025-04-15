package com.ai.spring.chatbot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotRestController {

    private final ChatBotService chatBotService;

    public ChatBotRestController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @GetMapping("/test")
    public String handleGetResponse() {
        return "Working";
    }


    @GetMapping("/ollama/chat")
    public String handleChatWithOllama(@RequestParam String message) {
        return chatBotService.chatWithOllama(message);
    }

    @GetMapping("/mistral/chat")
    public String handleChatWithMistral(@RequestParam String message) {
        return chatBotService.chatWithMistral(message);
    }

}
