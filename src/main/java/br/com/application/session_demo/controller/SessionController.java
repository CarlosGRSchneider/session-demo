package br.com.application.session_demo.controller;

import br.com.application.session_demo.entity.Session;
import br.com.application.session_demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionRepository repository;

    private static final String SESSION_ID = UUID.randomUUID().toString();

    @PostMapping
    public ResponseEntity<Session> handleSession(@RequestBody String name) {

        Session session = repository.findByName(name).orElse(new Session(name, SESSION_ID));
        session.increment();

        repository.save(session);
        return ResponseEntity.ok().body(session);
    }
}
