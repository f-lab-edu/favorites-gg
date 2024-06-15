package gg.favorites.user.controller;

import gg.favorites.common.exception.EntityNotFoundException;
import gg.favorites.common.response.CommonResponse;
import gg.favorites.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public CommonResponse getUser(@PathVariable String userId) {
        return CommonResponse.success(userService.findByUserId(userId));
    }

    @GetMapping(value = "/exception")
    public CommonResponse throwException() {
        throw new EntityNotFoundException("hi");
    }
}


