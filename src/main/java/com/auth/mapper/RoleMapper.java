package com.auth.mapper;

import com.auth.dto.RoleDto;
import com.auth.model.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDto dto);

}
