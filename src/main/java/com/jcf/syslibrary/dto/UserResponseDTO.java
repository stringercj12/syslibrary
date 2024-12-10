package com.jcf.syslibrary.dto;

import com.jcf.syslibrary.entities.Address;
import com.jcf.syslibrary.entities.Role;

import java.util.List;
import java.util.UUID;

public record UserResponseDTO(
  UUID userId,
  String firstName,
  String lastName,
  String email,
  List<Address> address,
  String phone,
  List<Role> roles,
  String username
  ) {
}
