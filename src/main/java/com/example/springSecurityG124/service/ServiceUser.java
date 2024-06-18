package com.example.springSecurityG124.service;

import com.example.springSecurityG124.model.Permission;
import com.example.springSecurityG124.model.User;
import com.example.springSecurityG124.repository.PermissionRepository;
import com.example.springSecurityG124.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUser {
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User)authentication.getPrincipal();
    }

    public void addUser(User user, String rePassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user1 = userRepository.findByEmail(user.getEmail());

        if(user1 != null) {
            return;
        }

        if(!user.getPassword().equals(rePassword)){
            return;
        }

        user.setPassword(passwordEncoder.encode(rePassword));

        Permission permission = permissionRepository.getStandartPermission();

        user.setPermissions(List.of(permission));

        userRepository.save(user);

    }
}
