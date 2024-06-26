package gg.favorites.api.user;

import gg.favorites.common.suppot.reponse.ApiResponse;
import gg.favorites.domain.user.UserNotFoundException;
import gg.favorites.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserApiController {
    private final UserService userService;

    @GetMapping(value = "/user/{userId}")
    public ApiResponse getUser(@PathVariable String userId) {
        return ApiResponse.success(userService.findByUserId(userId));
    }

    @GetMapping(value = "/exception")
    public ResponseEntity<?> throwException() {
        throw new UserNotFoundException(Level.WARN);
    }
}


