package com.auth.serviceimpl;

import com.auth.dto.RegisterUserRequestDto;
import com.auth.dto.RoleDto;
import com.auth.mapper.RoleMapper;
import com.auth.mapper.UsersMapper;
import com.auth.model.Role;
import com.auth.model.Users;
import com.auth.repository.RoleRepository;
import com.auth.repository.UsersRepository;
import com.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Enter valid username" + username));
        return User.builder()
                .username(users.getUsername())
                .password(users.getPasswordHash())
                .roles(users.getRole().getRoleName())
                .build();
    }

    @Override
    public String registerUser(RegisterUserRequestDto registerUserRequestDto) {
        Users user = usersMapper.toEntity(registerUserRequestDto, passwordEncoder, roleRepository);
        Users savedUser = usersRepository.save(user);

        return Optional.of(savedUser)
                .map(users -> "User created successfully with Username: " + users.getUsername())
                .orElse("User not saved!");
    }

    @Override
    public String createRole(RoleDto roleDto) {
        Role savedRole = roleRepository.save(roleMapper.toEntity(roleDto));
        return Optional.of(savedRole)
                .map(role -> "Role saved with ID: " + role.getRoleName())
                .orElse("Role could not be saved");
    }
}
