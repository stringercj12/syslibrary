package com.jcf.syslibrary.dtos;


import java.util.List;

public record UserRequestDTO(
        String username,
        String password,
        String firstName,
        String lastName,
        String email,
        String phone,
        AddressDTO address,
        List<String> roles
        ) {
}
