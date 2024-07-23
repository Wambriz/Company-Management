package com.teamblue.Management_App.mappers;

import com.teamblue.Management_App.dtos.ProfileDto;
import com.teamblue.Management_App.entities.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    Profile profileToProfileDto(Profile profile);
    Profile profileDtoToProfile(ProfileDto profileDto);
}
