package com.vignesh.tradingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vignesh.tradingApplication.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

}
