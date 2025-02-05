package com.practice.tacos.domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;

    private String password;

    private String fullName;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String phone;

}
