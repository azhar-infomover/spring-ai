package com.ai.spring.chatbot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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


    @GetMapping("/ai/chat")
    public Flux<String> handleChatWithAI(@RequestParam String message,
                                         @RequestHeader(required = false) String sessionId,
                                         @RequestHeader(required = false) String model) {
        return chatBotService.chatWithAI(message);
    }

    @GetMapping("/mistral/chat")
    public String handleChatWithMistral(@RequestParam String message) {
        return chatBotService.chatWithMistral(message);
    }

}
