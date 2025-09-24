package com.auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "users",schema = "resource", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email_id", "username"})
}
)
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            allocationSize = 1,
            sequenceName = "user_sequence"
    )
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email_id", nullable = false)
    private String emailId;
    @Column(name = "password_hash")
    private String passwordHash;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
}
