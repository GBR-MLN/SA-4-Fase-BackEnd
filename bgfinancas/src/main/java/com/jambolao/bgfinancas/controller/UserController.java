package com.jambolao.bgfinancas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jambolao.bgfinancas.model.user.User;
import com.jambolao.bgfinancas.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = service.listUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public ResponseEntity<User> read(@PathVariable Long id) {
        User user = service.readUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public ResponseEntity<User> readByEmail(@PathVariable String email) {
        User user = service.readUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = service.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}