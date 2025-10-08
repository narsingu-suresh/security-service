package com.auth.service;

import com.auth.dto.RegisterUserRequestDto;
import com.auth.dto.RoleDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

   public String registerUser(RegisterUserRequestDto registerUserRequestDto);

    String createRole(RoleDto roleDto);
}
