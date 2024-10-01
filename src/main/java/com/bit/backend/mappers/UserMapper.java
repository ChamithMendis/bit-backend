package com.bit.backend.mappers;

import com.bit.backend.dtos.SignUpDto;
import com.bit.backend.dtos.UserDto;
import com.bit.backend.entities.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
