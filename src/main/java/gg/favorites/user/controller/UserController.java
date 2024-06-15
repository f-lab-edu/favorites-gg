package gg.favorites.user.controller;

import gg.favorites.common.suppot.reponse.ApiResponse;
import gg.favorites.user.exception.UserNotFoundException;
import gg.favorites.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/user/{userId}")
    public ApiResponse getUser(@PathVariable String userId) {
        return ApiResponse.success(userService.findByUserId(userId));
    }

    @GetMapping(value = "/exception")
    public ResponseEntity<?> throwException() {
        throw new UserNotFoundException("유저를 찾을 수 없습니다.");
    }
}


