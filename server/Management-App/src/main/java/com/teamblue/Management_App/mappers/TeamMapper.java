package com.teamblue.Management_App.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.teamblue.Management_App.dtos.TeamDto;
import com.teamblue.Management_App.entities.Team;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TeamMapper {
    List<TeamDto> entitiesToDtos(List<Team> entities);
}

