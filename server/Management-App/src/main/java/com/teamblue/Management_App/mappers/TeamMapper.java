package com.teamblue.Management_App.mappers;

import com.teamblue.Management_App.dtos.TeamDto;
import com.teamblue.Management_App.entities.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDto entityToDto(Team team);
    Team dtoToEntity(TeamDto teamDto);
}

