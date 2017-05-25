package com.redhat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.spring.provider.SpringRemoteCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Repository
public class BrowserRepository {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpringRemoteCacheManager cacheManager;

    /* Not implemented yet */
    /* public List<String> listCacheNames(){

    	List<String> cacheNames = new ArrayList<String>();

    	Collection<String> c = cacheManager.getCacheNames();    	
       	c.forEach(entry -> cacheNames.add(entry));
    	return cacheNames;
    	
    	
    	
    	return null;
    }*/

    public List<String> listIndexes(String cacheName){
    	List<String> indexes = new ArrayList<String>();

    	RemoteCache<Object, Object> rc = cacheManager.getNativeCacheManager().getCache();
       	Set<Object> keySet = rc.keySet();
       	keySet.forEach(entry -> indexes.add(entry.toString()));
    	
    	return indexes;
    }
    
    public String getDataAsStringByKey(String cacheName, String key) throws JsonProcessingException{
    	RemoteCache<Object, Object> rc = cacheManager.getNativeCacheManager().getCache();
    	
    	if(!rc.containsKey(UUID.fromString(key))){
    		return null;
    	}
    	
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	return mapper.writeValueAsString(rc.get(UUID.fromString(key)));
    }
    

}