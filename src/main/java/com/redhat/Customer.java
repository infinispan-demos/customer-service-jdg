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
        
        log.info("Added Customer Id:" + this.id);
    }

    public Customer(UUID id) {
        this.id = UUID.randomUUID();
        
        log.info("Loaded Customer Id:" + this.id);
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
    
	/*
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Customer cust = (Customer) o;

		return this.id.equals(cust.id);
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
    */
	
}