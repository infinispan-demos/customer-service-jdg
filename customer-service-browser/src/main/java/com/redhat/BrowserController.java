package com.redhat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class BrowserController {
	
	@Autowired
	private BrowserRepository repository;

	/* Not implemented yet */
    /* @RequestMapping(method=RequestMethod.GET,value="/cache")
    public List<String> getCacheNames(
    		) {
    	    	return repository.listCacheNames();    		 
    }*/

    @RequestMapping(method=RequestMethod.GET,value="/cache/{cacheName}")
    public List<String> getIndexes(
    		@PathVariable(value="cacheName") String cacheName
    		) {
    		 return repository.listIndexes(cacheName);
    }

    @RequestMapping(method=RequestMethod.GET,value="/cache/{cacheName}/{key}")
    public String getDataAsString(
    		@PathVariable(value="cacheName") String cacheName,
    		@PathVariable(value="key") String key
    		) throws CustomerNotFoundException {
    	try{
    		return repository.getDataAsStringByKey(cacheName, key);
    	} catch (JsonProcessingException e){
    		throw new CustomerNotFoundException();
    	}
    }

       
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="This customer is not found in the system")
    public class CustomerNotFoundException extends RuntimeException 
    {
    	private static final long serialVersionUID = 100L;
    }
    
}