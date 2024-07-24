package com.teamblue.Management_App.mappers;

import com.teamblue.Management_App.dtos.AnnouncementDto;
import com.teamblue.Management_App.dtos.AnnouncementRequestDto;
import com.teamblue.Management_App.entities.Announcements;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BasicUserMapper.class})
public interface AnnouncementMapper {
    @Mapping(source = "author", target = "author")
    AnnouncementDto entityToDto(Announcements announcements);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(source = "author", target = "author")
    Announcements dtoToEntity(AnnouncementRequestDto announcementRequestDto);
    List<AnnouncementDto> entitiesToDtos(List<Announcements> announcements);
}