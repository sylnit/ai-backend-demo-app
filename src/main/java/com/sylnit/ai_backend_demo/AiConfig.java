package com.sylnit.ai_backend_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder.defaultSystem("You are an AI assistant that helps customers to answer questions about their customer details, past transactions. You must provide the amounts in Naira")
                .build();
    }
}
