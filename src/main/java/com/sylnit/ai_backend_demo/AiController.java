package com.sylnit.ai_backend_demo;

import com.sylnit.ai_backend_demo.tools.CustomerTools;
import com.sylnit.ai_backend_demo.tools.TransactionTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class AiController {

    private final OllamaChatModel ollamaChatModel;
    private final ChatClient chatClient;
    private final TransactionTools transactionTools;
    private final CustomerTools customerTools;

    public AiController(OllamaChatModel ollamaChatModel, ChatClient chatClient, TransactionTools transactionTools, CustomerTools customerTools) {
        this.ollamaChatModel = ollamaChatModel;
        this.chatClient = chatClient;
        this.transactionTools = transactionTools;
        this.customerTools = customerTools;
    }

    @GetMapping("/{message}")
    public ResponseEntity<?> getAnswer(
            @PathVariable(name = "message") String message
    ){
        //String response = ollamaChatModel.call(message); //use this model or use the chatClient
        String response = chatClient.prompt()
                .user(message)
                .tools(transactionTools, customerTools)
                .call()
                .content();
        String cleaned = response.replaceAll("(?s)<think>.*?</think>", "").trim();
        System.out.println("Response: "+cleaned);
        Map<Object, Object> dataMap = new HashMap<>();
        dataMap.put("response", Util.stripMarkdown(cleaned));
        return ResponseEntity.ok(dataMap);

    }
}
