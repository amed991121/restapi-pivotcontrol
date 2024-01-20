package com.example.demo.service;


import com.example.demo.constants.SessionConstants;
import com.example.demo.models.Session;
import com.example.demo.repository.SessionRepository;
import com.example.demo.util.MessageBody;
import com.example.demo.util.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;


    @Override
    public ResponseEntity<MessageBody> signUp(Map<String, String> requestMap) {
        try {
            if (validateMap(requestMap)) {
                Session session = sessionRepository.findByName(
                        requestMap.get("userName"));
                if (Objects.isNull(session)) {
                    sessionRepository.save(getSessionFromMap(requestMap));
                    return SessionUtils.getResponseEntity(
                            "Usuario registrado con exito",
                            null,
                            HttpStatus.CREATED);
                } else
                    return SessionUtils.getResponseEntity(
                            "El usuario con este nombre ya existe",
                            session,
                            HttpStatus.BAD_REQUEST);
            } else
                return SessionUtils.getResponseEntity(
                        SessionConstants.INVALID_DATA,
                        null,
                        HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SessionUtils.getResponseEntity(
                SessionConstants.SOMETHING_WENT_WRONG,
                null,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<MessageBody> login(Map<String, String> requestMap) {
        try {
            if (validateMap(requestMap)){
                Session session = sessionRepository.findByName(
                        requestMap.get("userName"));
                boolean isPassMatch = BCrypt.checkpw(
                        requestMap.get("password"),
                        session.getPassword());
                if (isPassMatch) {
                    return SessionUtils.getResponseEntity(
                            "Bienvenido",
                            session,
                            HttpStatus.OK);
                }
                else
                    return SessionUtils.getResponseEntity(
                            "Pin incorrecto",
                            null,
                            HttpStatus.UNAUTHORIZED);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return SessionUtils.getResponseEntity(
                "EL usuario no existe",
                null,
                HttpStatus.BAD_REQUEST);
    }

    private boolean validateMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("userName")) {
            return true;
        }
        return false;
    }

    private Session getSessionFromMap(Map<String, String> requestMap) {
        Session session = new Session();
        session.setName(requestMap.get("name"));
        session.setUserName(requestMap.get("userName"));
        String hashedPass = BCrypt.hashpw(requestMap.get("password"), BCrypt.gensalt(12));
        session.setPassword(hashedPass);
        session.setRole(requestMap.get("role"));
        return session;
    }

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getById(Long id) {
        return sessionRepository.findById(id).get();
    }

    @Override
    public Session update(Long id, Session session) {
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        if (sessionOptional.isPresent()) {
            sessionOptional.get().setName(session.getName());
            sessionOptional.get().setUserName(session.getUserName());
            String hashedPass = BCrypt.hashpw(session.getPassword(), BCrypt.gensalt(12));
            sessionOptional.get().setPassword(hashedPass);
            sessionOptional.get().setRole(session.getRole());
            return sessionRepository.save(sessionOptional.get());
        }
        throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        sessionRepository.deleteById(id);
    }

}
