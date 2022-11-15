package com.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.authentication.models.Project;
import com.authentication.models.User;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	
	List<Project> findByUsersContains(User user);
	List<Project> findByUsersNotContains(User user);
}
