package gg.favorites.user.service;

import gg.favorites.user.domain.User;
import gg.favorites.user.dto.UserInfo;
import gg.favorites.user.repository.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface UserService {

    UserInfo findByUserId(String userId);

    @Service
    @RequiredArgsConstructor
    class UserServiceImple implements UserService {
        private final UserReader userReader;

        @Override
        public UserInfo findByUserId(String userId) {
            var user = userReader.getUserByUserId(userId);
            return new UserInfo(user);
        }
    }
}
