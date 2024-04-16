package com.vignesh.tradingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vignesh.tradingApplication.model.Portfolio;

@Repository
public interface portfolioRepository extends JpaRepository<Portfolio, Integer> {

	
	@Query(value = "select * from portfolio where  user_id=:id1", nativeQuery = true)
	List<Portfolio> findByUserIdAndStockId(Integer id1);
	
	@Query(value = "select * from portfolio where stock_id=:id2", nativeQuery = true)
	List<Portfolio> findByStockId(Integer id2);
	
	
}
