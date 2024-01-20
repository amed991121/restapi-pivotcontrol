package com.example.demo.service;

import com.example.demo.models.Session;
import com.example.demo.util.MessageBody;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface SessionService {

    ResponseEntity<MessageBody> signUp(Map<String, String> requestMap);

    ResponseEntity<MessageBody> login(Map<String, String> requestMap);
    List<Session> getAll();

    Session getById(Long id);

    Session update(Long id, Session session);

    void delete(Long id);
}
