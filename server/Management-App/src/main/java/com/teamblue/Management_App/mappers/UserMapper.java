package com.teamblue.Management_App.mappers;

import java.util.List;

import com.teamblue.Management_App.dtos.BasicUserDto;
import com.teamblue.Management_App.dtos.FullUserDto;
import com.teamblue.Management_App.dtos.UserRequestDto;
import com.teamblue.Management_App.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class, CompanyMapper.class})
public interface UserMapper {


    FullUserDto entityToDto(User entity);


	User requestDtoToEntity(UserRequestDto userRequestDto);

	List<BasicUserDto> entitiesToDtos(List<User> all);

    FullUserDto entityToFullUserDto(User user);
	User fullUSerDtoToEntity(FullUserDto fullUserDto);

    BasicUserDto entityToBasicDto(User user);
    
    User basicUserDtoToEntity(BasicUserDto basicUserDto);


    List<FullUserDto> entitiesToDtos(List<User> entities);
	
	User RequestDtoToEntity(FullUserDto fullUserDto);

}
