package com.vignesh.tradingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.MarketData;
import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.repository.MarketDataRepository;
import com.vignesh.tradingApplication.repository.StockRepository;
import com.vignesh.tradingApplication.repository.UserRepository;

@Service
public class MarketDataService {
	
	  @Autowired
	    private MarketDataRepository marketDataRepository;
	  @Autowired
		 private UserRepository userrepository;
		 @Autowired
		 private StockRepository repository;

	    public List<MarketData> getAllMarketData() {
	        return marketDataRepository.findAll();
	    }

	    public Optional<MarketData> getMarketDataById(Integer id) {
	        return marketDataRepository.findById(id);
	    }

	    public MarketData createMarketData(int id1,MarketData marketData) {

	    	//Optional<UserTable>user=userrepository.findById(id1);
	        Optional<Stock>stock=repository.findById(id1);
	        Stock stock1=stock.get();
		   // UserTable user1=user.get();
		    MarketData data=new MarketData();
		    data.setStock(stock1);
		    data.setClosePrice(marketData.getClosePrice());
		    data.setDate(marketData.getDate());
		    data.setHighPrice(marketData.getHighPrice());
		    data.setLowPrice(marketData.getLowPrice());
		    data.setOpenPrice(marketData.getOpenPrice());
		    data.setVolume(marketData.getVolume());
	    
	        return marketDataRepository.save(marketData);
	    }

	    public MarketData updateMarketData(Integer id, MarketData marketDataDetails) {
	        Optional<MarketData> marketDataOptional = marketDataRepository.findById(id);
	        if (marketDataOptional.isPresent()) {
	            MarketData existingMarketData = marketDataOptional.get();
	            existingMarketData.setStock(marketDataDetails.getStock());
	            existingMarketData.setDate(marketDataDetails.getDate());
	            existingMarketData.setOpenPrice(marketDataDetails.getOpenPrice());
	            existingMarketData.setHighPrice(marketDataDetails.getHighPrice());
	            existingMarketData.setLowPrice(marketDataDetails.getLowPrice());
	            existingMarketData.setClosePrice(marketDataDetails.getClosePrice());
	            existingMarketData.setVolume(marketDataDetails.getVolume());
	            // Update other properties as needed
	            return marketDataRepository.save(existingMarketData);
	        } else {
	            // Handle market data not found error
	            return null;
	        }
	    }

	    public void deleteMarketData(Integer id) {
	        marketDataRepository.deleteById(id);
	    }
	

}
