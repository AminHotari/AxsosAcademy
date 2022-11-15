package com.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Title is required!")
    @Size(min=3, max=30, message="Title must be between 3 and 30 characters")
    private String title;
    
    @NotEmpty(message="Description is required!")
    @Size(min=3, max=30, message="Description must be between 3 and 30 characters")
    private String description;
    
    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userCreate_id")
    private User userCreate;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "users_projects", 
    		joinColumns = @JoinColumn(name = "project_id"), 
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;    
    
    public Project() {
        
    }
    

    public Project(Long id, String title, String description, Date dueDate, User userCreate, List<User> users) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.userCreate = userCreate;
		this.users = users;
	}


	public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getTitle() {
    	return title;
    }

    public void setTitle(String title) {
    	this.title = title;
    }	

    public String getDescription() {
    	return description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }


    public Date getDueDate() {
    	return dueDate;
    }

    public void setDueDate(Date dueDate) {
    	this.dueDate = dueDate;
    }

    public List<User> getUsers() {
    	return users;
    }

    public void setUsers(List<User> users) {
    	this.users = users;
    }


    public User getUserCreate() {
    	return userCreate;
    }

    public void setUserCreate(User userCreate) {
    	this.userCreate = userCreate;
    }
    

    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }

}
