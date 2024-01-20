package com.example.demo.controllers;

import com.example.demo.constants.SessionConstants;
import com.example.demo.models.Session;
import com.example.demo.service.SessionService;
import com.example.demo.util.MessageBody;
import com.example.demo.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/pivot-control")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping(value = "/session")
    @ResponseStatus(HttpStatus.OK)
    public List<Session> getAll() {
        return sessionService.getAll();
    }

    @GetMapping(value = "/session/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getById(@PathVariable Long id) {
        return sessionService.getById(id);
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<MessageBody> signIn(
            @RequestBody(required = true) Map<String, String> requestMap
    ) {
        try {
            return sessionService.login(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SessionUtils.getResponseEntity(
                SessionConstants.SOMETHING_WENT_WRONG,
                null,
                HttpStatus.BAD_REQUEST
        );
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<MessageBody> addUser(
            @RequestBody(required = true) Map<String, String> requestMap
    ) {
        try {
            return sessionService.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SessionUtils.getResponseEntity(
                SessionConstants.SOMETHING_WENT_WRONG,
                null,
                HttpStatus.BAD_REQUEST
        );
    }

    @PutMapping(value = "/session/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return sessionService.update(id, session);
    }

    @DeleteMapping(value = "/session/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }


}
