package com.teamblue.Management_App.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamblue.Management_App.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}