package com.teamblue.Management_App.mappers;

import java.util.List;

import com.teamblue.Management_App.dtos.TeamRequestDto;
import org.mapstruct.Mapper;

import com.teamblue.Management_App.dtos.TeamDto;
import com.teamblue.Management_App.entities.Team;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TeamMapper {
    TeamDto entityToDto(Team entity);
    List<TeamDto> entitiesToDtos(List<Team> entities);
    Team RequestDtoToEntity(TeamRequestDto requestDto);
}

