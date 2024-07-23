package com.teamblue.Management_App.mappers;

import com.teamblue.Management_App.dtos.CredentialsDto;
import com.teamblue.Management_App.entities.Credentials;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CredentialsMapper {
    CredentialsMapper INSTANCE = Mappers.getMapper(CredentialsMapper.class);

    CredentialsDto credentialsToCredentialsDto(Credentials credentials);
    Credentials credentialsDtoToCredentials(CredentialsDto credentialsDto);

}
