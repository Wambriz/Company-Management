package com.teamblue.Management_App.mappers;

import java.util.List;

import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.UserRequestDto;
import com.teamblue.Management_App.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class, CompanyMapper.class})

public interface UserMapper {

//	@Mapping(target="username", source="credentials.username")
    FullUserDto entityToDto(User entity);

    List<FullUserDto> entitiesToDtos(List<User> entities);
	
	User FullUserDtoToEntity(FullUserDto fullUserDto);

    User UserRequestDtoToEntity(UserRequestDto userRequestDto);
}
