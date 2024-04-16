package com.vignesh.tradingApplication.repository;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vignesh.tradingApplication.model.UserTable;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Integer>{

	
	@Query(value = "select * from usertable where registration_date between :date1 and :date2", nativeQuery = true)
	List<UserTable> findByDateBetween(Date date1, Date date2);
	
	
	@Query(value = "select * from usertable where username=:username && password=:password", nativeQuery = true)
	Optional<UserTable> findByUsernameAndPassword(String username, String password);
	
	
//	@Query(value = "select * from usertable", nativeQuery = true)
//	List<UserTable> findAll();
	
}
