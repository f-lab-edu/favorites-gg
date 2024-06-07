package gg.favorites.user.controller;

import gg.favorites.exception.ErrorCode;
import gg.favorites.user.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {

    @GetMapping(value = "/user")
    public String getUser() {
        return "hello world!";
    }

    @GetMapping(value = "/exception")
    public ResponseEntity<?> throwException() {
        throw new UserException(ErrorCode.BAD_REQUEST);
    }
}


