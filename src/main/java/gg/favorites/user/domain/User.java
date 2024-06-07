package gg.favorites.user.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private boolean alertEnabled;

    public User() {}

    public User(String userId, String password, String email, boolean alertEnabled) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.alertEnabled = alertEnabled;
    }

}
