package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if(pin> 99999) {
			authIncident();
			return true;
			
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID.equals(this.id)) {
			return true;
		}
		return false;
	}

//	@Override
//	public ArrayList<String> reportSecurityIncidents() {
//		ArrayList<String> repo = new ArrayList<String>();
//		for(int i=0; i<repo.size(); i++) {
//			repo[i] = authIncident();
//			
//		}
//		
//		
//		return null;
//	}
	
	 public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.id, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }

}
