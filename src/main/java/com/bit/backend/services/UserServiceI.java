package com.bit.backend.services;

import com.bit.backend.dtos.CredentialsDto;
import com.bit.backend.dtos.SignUpDto;
import com.bit.backend.dtos.UserDto;

public interface UserServiceI {
    UserDto login(CredentialsDto credentialsDto);
    UserDto register(SignUpDto signUpDto);
}
