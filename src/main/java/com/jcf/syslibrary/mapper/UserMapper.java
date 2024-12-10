package com.jcf.syslibrary.mapper;

import com.jcf.syslibrary.dto.UserRequestDTO;
import com.jcf.syslibrary.dto.UserResponseDTO;
import com.jcf.syslibrary.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User toEntity(UserRequestDTO userDto) {
    if (userDto == null) {
      return null;
    }
    User user = new User();
    user.setFirstName(userDto.firstName());
      user.setLastName(userDto.lastName());
    user.setEmail(userDto.email());
    user.setPassword(passwordEncoder.encode(userDto.password()));
      user.setEmail(userDto.email());
//      user.setAddress(List.of(userDto.address()));
    System.out.println(userDto.roles());
      user.setRoles(List.of());
      user.setPhone(userDto.phone());
      user.setUsername(userDto.username());

//      rever objeto?
//    {
//      "username": "jefferson",
//      "password": "123",
//      "firstName": "Jefferson",
//      "lastName": "Clementino Ferreira",
//      "email": "jefferson14489@gmail.com",
//      "phone": "21966187719",
//      "address": {
//      "street": "Rua dos diaristas",
//        "city": "Rio de Janeiro",
//        "state": "Rio de Janeiro",
//        "zip": "23055330",
//        "country": "Brazil",
//        "isPrincipal": "true"
//    },
//      "roles": [
//      "basic"
//  ]
//    }
    return user;
  }

  public UserResponseDTO toDto(User user) {
    if (user == null) {
      return null;
    }
    return new UserResponseDTO(
      user.getUserId(),
      user.getFirstName(),
      user.getLastName(),
      user.getEmail(),
      user.getAddress(),
      user.getPhone(),
      user.getRoles(),
      user.getUsername()
    );
  }

  public void updateEntity(UserRequestDTO userDto, User user) {
    if (userDto != null) {
      user.setFirstName(userDto.firstName());
      user.setEmail(userDto.email());

      if (userDto.password() != null) {
        user.setPassword(passwordEncoder.encode(userDto.password()));
      }
    }
  }
}
