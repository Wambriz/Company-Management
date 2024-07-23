package com.teamblue.Management_App.mappers;

import java.util.List;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    FullUserDto entityToDto(User user);
}
