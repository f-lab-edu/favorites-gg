package gg.favorites.user.dto;

import gg.favorites.user.domain.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserInfo {
    private final String userId;
    private final String email;
    private final boolean alertEnabled;

    public UserInfo(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.alertEnabled = user.isAlertEnabled();
    }
}
