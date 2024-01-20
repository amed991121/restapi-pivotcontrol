package com.example.demo.util;

import com.example.demo.models.Session;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class SessionUtils {

    private SessionUtils() {

    }

    public static ResponseEntity<MessageBody> getResponseEntity(
            String message,
            Session session,
            HttpStatus httpStatus
    ) {
        String jsonString = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("message", message);
            jsonString = objectMapper.writeValueAsString(jsonNode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                new MessageBody(
                        message = message,
                        session = session),
                httpStatus
        );
    }
}
