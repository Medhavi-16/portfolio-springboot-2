package com.example.portfolio.dao;

import com.example.portfolio.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository<Profile, String> {

}
