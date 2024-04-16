package com.vignesh.tradingApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.Portfolio;
import com.vignesh.tradingApplication.repository.StockRepository;
import com.vignesh.tradingApplication.repository.UserRepository;
import com.vignesh.tradingApplication.repository.portfolioRepository;
@Service
public class StockUserReportService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private portfolioRepository portfolioRepository;
	
	public List<Portfolio> userStock(Integer id1){
		

	List<Portfolio> port=portfolioRepository.findByStockId(id1);
	
	return port;
		
	}

}
