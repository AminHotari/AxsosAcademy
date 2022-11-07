package com.saveTravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
    @Size(min = 5, max = 200, message="Name must not be Blank")
    private String name1;
	@NotNull
    @Size(min = 5, max = 200, message="Vendor must be atleast 5 char")
    private String vendor;
	@NotNull(message="Amount must not be Blank")
    @Min(value = 0, message="Amount must be greater than 0")
    private Double amount;
	@NotNull
    @Size(min = 5, max = 200, message="Description must not be Blank")
    private String description;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense() {
		
	}
    
    public Expense(String name1, String vendor,Double amount,String description) {
		this.name1 = name1;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name) {
		this.name1 = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
