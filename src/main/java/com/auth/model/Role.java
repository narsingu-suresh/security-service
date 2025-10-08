package com.auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "role", schema = "resource")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", allocationSize = 1, sequenceName = "role_sequence")
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;
}
