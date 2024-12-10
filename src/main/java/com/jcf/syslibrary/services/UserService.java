package com.jcf.syslibrary.services;


import com.jcf.syslibrary.dto.UserRequestDTO;
import com.jcf.syslibrary.dto.UserResponseDTO;
import com.jcf.syslibrary.entities.User;
import com.jcf.syslibrary.exceptions.ResourceNotFoundException;
import com.jcf.syslibrary.mapper.UserMapper;
import com.jcf.syslibrary.repository.RoleRepository;
import com.jcf.syslibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserService {

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  public UserService(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  public List<UserResponseDTO> getAllUsers() {
    UserMapper userMapper = new UserMapper();
    return userRepository
      .findAll()
      .stream()
      .map((user) -> userMapper.toDto(user))
      .collect(Collectors.toList());
  }

  public UserResponseDTO getUserById(UUID id) {
    User user = userRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    UserMapper userMapper = new UserMapper();

    return userMapper.toDto(user);
  }

  public UserResponseDTO createUser(UserRequestDTO userDto) {
    UserMapper userMapper = new UserMapper();
    User user = userMapper.toEntity(userDto);
    User savedUser = userRepository.save(user);
    return userMapper.toDto(savedUser);
  }

  public UserResponseDTO updateUser(UUID id, UserRequestDTO userDto) {
    User user = userRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    UserMapper userMapper = new UserMapper();

    userMapper.updateEntity(userDto, user);
    User updatedUser = userRepository.save(user);
    return userMapper.toDto(updatedUser);
  }

  public void deleteUser(UUID id) {
    if (!userRepository.existsById(id)) {
      throw new ResourceNotFoundException("User not found");
    }
    userRepository.deleteById(id);
  }

}
