package gg.favorites.domain.user;

import gg.favorites.api.user.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface UserService {

    UserInfo findByUserId(String userId);
}
