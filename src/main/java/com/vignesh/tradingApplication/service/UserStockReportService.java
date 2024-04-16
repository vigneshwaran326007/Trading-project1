package com.vignesh.tradingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.Portfolio;
import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.repository.StockRepository;
import com.vignesh.tradingApplication.repository.UserRepository;
import com.vignesh.tradingApplication.repository.portfolioRepository;

@Service
public class UserStockReportService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private portfolioRepository portfolioRepository;
	
	public List<Portfolio> userStock(Integer id1){
		
//	Optional<UserTable> user=	userRepository.findById(id1);
//	Optional<Stock> stock=    stockRepository.findById(id2);
//	if(user.isPresent()) {
//		if(stock.isPresent()) {
//			UserTable user1=user.get();
//			Stock stock1=stock.get();
//			portfolioRepository.findByUserIdAndStockId(id1, id2);
//		}
//	}
	List<Portfolio> port=portfolioRepository.findByUserIdAndStockId(id1);
	return port;
		
	}

}
