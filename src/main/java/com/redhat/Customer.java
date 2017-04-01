package com.redhat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
public class Customer implements Serializable {
    Logger log = LoggerFactory.getLogger(this.getClass());

	private UUID id;
	
    private String firstName;
    private String lastName;
    private String email;

    public Customer(UUID id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
	public UUID getId() {
        return id;
    }
	
	public void setId(UUID id) {
        this.id = id;
    }
	
    public String getFirstName() {
        return firstName;
    }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    	
}