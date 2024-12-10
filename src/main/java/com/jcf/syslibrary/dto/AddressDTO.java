package com.jcf.syslibrary.dto;

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
