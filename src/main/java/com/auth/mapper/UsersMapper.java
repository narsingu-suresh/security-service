package com.auth.mapper;

import com.auth.dto.RegisterUserRequestDto;
import com.auth.model.Users;
import com.auth.repository.RoleRepository;
import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true) // handle in @AfterMapping
    Users toEntity(RegisterUserRequestDto dto, @Context PasswordEncoder encoder, @Context RoleRepository roleRepo);

    @AfterMapping
    default void afterMapping(RegisterUserRequestDto dto, @MappingTarget Users user,
                              @Context PasswordEncoder encoder,
                              @Context RoleRepository roleRepo) {

        // encode password
        user.setPasswordHash(encoder.encode(dto.getPassword()));

        // set role from DB
        if (dto.getRole() != null && dto.getRole().getRoleName() != null) {
            roleRepo.findByRoleName(dto.getRole().getRoleName())
                    .ifPresent(user::setRole); // user.setRole(role)
        }
    }
}

