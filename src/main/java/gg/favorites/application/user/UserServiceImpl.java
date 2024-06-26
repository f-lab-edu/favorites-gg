package gg.favorites.application.user;

import gg.favorites.api.user.UserInfo;
import gg.favorites.domain.user.UserReader;
import gg.favorites.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserReader userReader;

    @Override
    public UserInfo findByUserId(String userId) {
        var user = userReader.getUserByUserId(userId);
        return new UserInfo(user);
    }
}