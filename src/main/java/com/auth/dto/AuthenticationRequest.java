package com.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotBlank(message = "username must be required")
    private String username;
    @NotBlank(message = "password must be required")
    private String password;
}
