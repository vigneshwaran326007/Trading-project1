package com.vignesh.tradingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.Portfolio;
import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.model.Transaction;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.repository.StockRepository;
import com.vignesh.tradingApplication.repository.UserRepository;
import com.vignesh.tradingApplication.repository.portfolioRepository;

@Service
public class PortfolioService {
	
	 @Autowired
	    private portfolioRepository portfolioRepository;
	 @Autowired
	 private UserRepository userrepository;
	 @Autowired
	 private StockRepository repository;

	    public List<Portfolio> getAllPortfolios() {
	        return portfolioRepository.findAll();
	    }

	    public Optional<Portfolio> getPortfolioById(Integer id) {
	        return portfolioRepository.findById(id);
	    }

	    public Portfolio createPortfolio(int id1,int id2,Portfolio portfolio) {
	    
	    	Optional<UserTable>user=userrepository.findById(id1);
	    Optional<Stock>stock=repository.findById(id2);
	    
	   
	    Stock stock1=stock.get();
	    UserTable user1=user.get();
	    Portfolio port=new Portfolio();
	    port.setStock(stock1);
	    port.setUser(user1);
	    port.setQuantity(portfolio.getQuantity());
	    port.setAveragePrice(portfolio.getAveragePrice());
	    port.setTotalInvestment(portfolio.getTotalInvestment());
	    	
	        return portfolioRepository.save(port);
	    }

	    public Portfolio updatePortfolio(Integer id, Portfolio portfolioDetails) throws UserNotFoundException {
	        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(id);
	        if (portfolioOptional.isPresent()) {
	            Portfolio existingPortfolio = portfolioOptional.get();
	            existingPortfolio.setUser(portfolioDetails.getUser());
	            existingPortfolio.setStock(portfolioDetails.getStock());
	            existingPortfolio.setQuantity(portfolioDetails.getQuantity());
	            existingPortfolio.setAveragePrice(portfolioDetails.getAveragePrice());
	            existingPortfolio.setTotalInvestment(portfolioDetails.getTotalInvestment());
	            // Update other properties as needed
	            return portfolioRepository.save(existingPortfolio);
	        } else {
	        	throw new UserNotFoundException("invalid id");
	        }
	    }

	    public void deletePortfolio(Integer id) {
	        portfolioRepository.deleteById(id);
	    }

}
