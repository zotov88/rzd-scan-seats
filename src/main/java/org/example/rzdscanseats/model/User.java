package org.example.rzdscanseats.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "rzd", name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "users_unique_login", columnNames = "login"),
                @UniqueConstraint(name = "users_unique_email", columnNames = "email")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "routes")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String changePasswordToken;

    private String tgBotToken;

    private Long tgChatId;

    @Builder.Default
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "user")
    private List<Route> routes = new ArrayList<>();
}
