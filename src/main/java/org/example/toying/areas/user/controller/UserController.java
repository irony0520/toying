package org.example.toying.areas.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.toying.areas.user.command.UserRegiseterCommand;
import org.example.toying.areas.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegiseterCommand command) {
        userService.registerUser(command);
        return ResponseEntity.ok("회원가입 완료");
    }
}
