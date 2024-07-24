package com.teamblue.Management_App.mappers;

import com.teamblue.Management_App.dtos.CompanyDto;
import com.teamblue.Management_App.entities.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TeamMapper.class})
public interface CompanyMapper {
    CompanyDto entityToDto(Company company);
    Company dtoToEntity(CompanyDto companyDto);
}
