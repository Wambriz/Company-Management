package com.teamblue.Management_App.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TeamMapper.class})
public interface ProjectMapper {
}

