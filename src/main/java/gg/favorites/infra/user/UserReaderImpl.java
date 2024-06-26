package gg.favorites.infra.user;

import gg.favorites.domain.user.User;
import gg.favorites.domain.user.UserNotFoundException;
import gg.favorites.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public  class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() ->
                new UserNotFoundException(String.format("다음 사용자를 찾을 수 없습니다 : %s", userId)));
    }
}