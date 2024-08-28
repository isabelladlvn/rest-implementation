package com.day3.rest_implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable String id) {
        User user = userService.getUser(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insertUser(@RequestBody User user) {
        try {
            userService.insertUser(user);
            return ResponseEntity.ok().body("User successfully inserted");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
