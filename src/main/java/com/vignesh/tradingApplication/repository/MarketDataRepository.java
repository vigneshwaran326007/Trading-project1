package com.vignesh.tradingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vignesh.tradingApplication.model.MarketData;

@Repository
public interface MarketDataRepository extends JpaRepository<MarketData, Integer> {

}
