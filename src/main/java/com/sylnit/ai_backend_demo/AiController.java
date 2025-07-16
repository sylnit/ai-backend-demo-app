package com.sylnit.ai_backend_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class AiController {

    private OllamaChatModel ollamaChatModel;

    public AiController(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<?> getAnswer(
            @PathVariable(name = "message") String message
    ){
        String response = ollamaChatModel.call(message);
        String cleaned = response.replaceAll("(?s)<think>.*?</think>", "").trim();
        System.out.println("Response: "+cleaned);
        Map<Object, Object> dataMap = new HashMap<>();
        dataMap.put("response", Util.stripMarkdown(cleaned));
        return ResponseEntity.ok(dataMap);
    }
}
