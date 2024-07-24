package com.teamblue.Management_App.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TeamMapper.class})
public interface CompanyMapper {
}
