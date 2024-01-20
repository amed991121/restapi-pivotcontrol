package com.example.demo.util;

import com.example.demo.models.Session;
import lombok.Data;

@Data
public class MessageBody {
    private String message;
    private Session session;

    public MessageBody(String s, Session session) {
        message = s;
        this.session = session;
    }
}
