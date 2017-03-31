package com.afc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.afc.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{
	List<Staff> findByName(String name);

}
