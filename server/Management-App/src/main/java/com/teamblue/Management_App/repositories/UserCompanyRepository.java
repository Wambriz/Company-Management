package com.teamblue.Management_App.repositories;

import com.teamblue.Management_App.entities.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {

}
