package com.redhat;

import java.util.UUID;

public interface CustomerRepositoryCache {

	    public Customer findById(UUID id);

	    public Customer insert(UUID id, Customer c);
	    
	    public void delete(UUID id);
}
