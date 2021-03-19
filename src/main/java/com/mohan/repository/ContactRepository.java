package com.mohan.repository;  
import org.springframework.data.repository.CrudRepository;  
//repository that extends CrudRepository  
public interface ContactRepository extends CrudRepository<com.mohan.model.Contact, Integer>  
{  
	
}