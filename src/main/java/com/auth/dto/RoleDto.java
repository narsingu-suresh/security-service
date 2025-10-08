package com.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    @NotBlank(message = "roleName must be required")
    private String roleName;
}
