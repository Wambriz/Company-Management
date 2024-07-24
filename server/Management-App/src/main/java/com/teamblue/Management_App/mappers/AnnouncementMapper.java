package com.teamblue.Management_App.mappers;

import com.teamblue.Management_App.dtos.AnnouncementDto;
import com.teamblue.Management_App.entities.Announcements;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AnnouncementMapper {
    AnnouncementDto entityToDto(Announcements announcements);
    Announcements dtoToEntity(AnnouncementDto announcementDto);
}

