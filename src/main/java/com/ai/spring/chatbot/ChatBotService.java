package com.ai.spring.chatbot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class ChatBotService {

    private final ChatClient ollamaClient;
    private final ChatClient mistralClient;

    public ChatBotService(
            OllamaChatModel ollamaChatModel,
            MistralAiChatModel mistralAiChatModel) {
        this.ollamaClient = ChatClient.builder(ollamaChatModel).build();
        this.mistralClient = ChatClient.builder(mistralAiChatModel).build();
    }

//    public String chatWithOpenAI(String message) {
//        return openAiClient.prompt()
//                .user(message)
//                .call()
//                .content();
//    }

    public Flux<String> chatWithOllama(String message) {
        return ollamaClient.prompt()
                .user(message)
                .stream()
                .content();
    }

    public String chatWithMistral(String message) {
        return mistralClient.prompt()
                .user(message)
                .call()
                .content();
    }

//    public String getResponse(String prompt) {
//        return chatModel.call(prompt);
//    }
}