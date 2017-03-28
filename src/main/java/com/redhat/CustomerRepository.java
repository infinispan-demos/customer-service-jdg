package com.redhat;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@CacheConfig(cacheNames="customer")
public class CustomerRepository {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Cacheable(key="#id")
    public Customer findById(UUID id){
    	return new Customer(id); 	
    }

    @CachePut(key="#id")
    public Customer insert(UUID id, String firstName, String lastName, String email){
        return new Customer(id, firstName, lastName, email);
    }
    
    @CacheEvict(key="#id")
    public void delete(UUID id){
    }

}