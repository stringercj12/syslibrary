package com.jcf.syslibrary.dtos;

public record AddressDTO(
        String addressId,
        String street,
        String city,
        String state,
        String zip,
        String country,
        String isPrincipal
) {
}
