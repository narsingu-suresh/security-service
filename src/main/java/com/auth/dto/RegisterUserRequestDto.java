package com.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    @NotBlank(message = "username must be required")
    private String username;
    @NotBlank(message = "password must be required")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,64}$",
            message = "Password must be 8+ characters, include upper and lower case letters, a number and a special character"
    )
    private String password;
    @NotBlank(message = "emailId must be required")
    @Email
    private String emailId;
    private RoleDto role;
}
