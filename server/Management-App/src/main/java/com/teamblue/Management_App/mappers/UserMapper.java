package com.teamblue.Management_App.mappers;

import java.util.List;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class})
public interface UserMapper {
    @Mapping(source = "admin", target = "isAdmin")
    FullUserDto entityToDto(User entity);
	
	User RequestDtoToEntity(FullUserDto fullUserDto);
}
