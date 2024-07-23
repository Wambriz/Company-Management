package com.teamblue.Management_App.mappers;

import java.util.List;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class})
//@Mapper
public interface UserMapper {
//	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
//	@Mapping(target="username", source="credentials.username")
    FullUserDto entityToDto(User entity);
	
	User RequestDtoToEntity(FullUserDto fullUserDto);
}
