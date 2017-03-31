package com.afc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.afc.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {
	List<Faculty> findByName(String name);
	
	
}
