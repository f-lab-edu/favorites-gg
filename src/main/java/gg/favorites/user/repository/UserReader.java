package gg.favorites.user.repository;

import gg.favorites.user.domain.User;
import gg.favorites.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public interface UserReader {
    User getUserByUserId(String userId);

    @Component
    @RequiredArgsConstructor
    class UserRepositoryImple implements UserReader {
        private final UserRepository userRepository;

        @Override
        public User getUserByUserId(String userId) {
            return userRepository.findByUserId(userId).orElseThrow(UserNotFoundException::new);
        }
    }
}
