package com.vignesh.tradingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.repository.StockRepository;

@Service
public class StockService {
	

	@Autowired
	private StockRepository repository;
	
	public List<Stock> getAllStock(){
		return repository.findAll();
		
	}
	public  Optional<Stock> getStockById(Integer id){
		return repository.findById(id);
		
	}
	public Stock createStock(Stock user) {
		return repository.save(user);
		
	}
	
	public Stock updateStock(Integer id,Stock stockDetails) throws UserNotFoundException {
		Optional<Stock> stockOptional=repository.findById(id);
		if(stockOptional.isPresent()) {
			Stock existingStock=stockOptional.get();
			existingStock.setSymbol(stockDetails.getSymbol());
			existingStock.setCompanyName(stockDetails.getCompanyName());
			existingStock.setcurrentPrice(stockDetails.getCurrentPrice());
			
			return repository.save(existingStock);
		}
		else {
			
			throw new UserNotFoundException("invalid id");
			
		}
		
		
		
	}
	public void deleteStock(Integer id) {
		repository.deleteById(id);
	}


}
