package com.ai.spring.chatbot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChatBotService {

    private final ChatClient ollamaClient;
    private final ChatClient mistralClient;
    private final List<Message> conversationHistory = new ArrayList<>();

    public ChatBotService(
            OllamaChatModel ollamaChatModel,
            MistralAiChatModel mistralAiChatModel) {
        this.ollamaClient = ChatClient.builder(ollamaChatModel).build();
        this.mistralClient = ChatClient.builder(mistralAiChatModel).build();
    }


    public Flux<String> chatWithAI(String message) {

        conversationHistory.add(new UserMessage(message));

        return ollamaClient.prompt()
                .messages(conversationHistory)
                .stream()
                .content()
                .doOnNext(response -> {
                    conversationHistory.add(new UserMessage(message));
                });
    }

    public String chatWithMistral(String message) {
        return mistralClient.prompt()
                .user(message)
                .call()
                .content();
    }

}