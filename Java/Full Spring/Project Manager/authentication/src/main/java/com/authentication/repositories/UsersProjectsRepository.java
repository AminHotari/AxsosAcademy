package com.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.authentication.models.users_projects;
@Repository
public interface UsersProjectsRepository extends CrudRepository<users_projects, Long> {

}
