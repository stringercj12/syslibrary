package com.jcf.syslibrary.services;


import com.jcf.syslibrary.dtos.UserRequestDTO;
import com.jcf.syslibrary.dtos.UserResponseDTO;
import com.jcf.syslibrary.repository.RoleRepository;
import com.jcf.syslibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().build();
    }

}
