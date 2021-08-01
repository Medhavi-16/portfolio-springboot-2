package com.example.portfolio.dao;

import com.example.portfolio.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsDao extends JpaRepository<Projects, String> {

}
