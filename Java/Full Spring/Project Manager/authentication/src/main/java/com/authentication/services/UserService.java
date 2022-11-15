package com.authentication.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.authentication.models.LoginUser;
import com.authentication.models.Project;
import com.authentication.models.User;
import com.authentication.repositories.ProjectRepository;
import com.authentication.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    private ProjectRepository projectRepository;
    
    public UserService(UserRepository userRepo, ProjectRepository projectRepository) {
		this.userRepo = userRepo;
		this.projectRepository = projectRepository;
	}
    
    public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    public User findUserById(Long id) {
        Optional<User> u = userRepo.findById(id);

        if(u.isPresent()) {
            return u.get();
            } else {
            return null;
        }
    }
    
    public List<Project> allProjects(){
    	return projectRepository.findAll();
    }
    
    public List<Project> userContains(User user1){
    	return projectRepository.findByUsersContains(user1);
    }
    
    public List<Project> notContains(User user2){
    	return projectRepository.findByUsersNotContains(user2);
    }
    
    public Project createProject(Project project1) {
    	return projectRepository.save(project1);
    }
    
    public Project findProjectById(Long id) {
    	return projectRepository.findById(id).orElse(null);
    }
    
//    public Project findById(Long id) {
//    	Optional<Project> optionalProject = projectRepository.findById(id);
//    	if(optionalProject.isPresent()) {
//    		return optionalProject.get();
//    	}
//    	else {
//    		return null;
//    	}
//    }
    
    public Project updateProject(Project project2) {
    	return projectRepository.save(project2);
    }
    
    public void deleteProject(Long id) {
    	projectRepository.deleteById(id);
    }
    
} 
