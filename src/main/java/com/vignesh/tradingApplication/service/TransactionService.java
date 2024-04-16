package com.vignesh.tradingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.model.Transaction;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.repository.StockRepository;
import com.vignesh.tradingApplication.repository.TransactionRepository;
import com.vignesh.tradingApplication.repository.UserRepository;

@Service
public class TransactionService {
	

	@Autowired
	private TransactionRepository repository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StockRepository stockRepository;
	
	public List<Transaction> getAllTransaction(){
		
		return repository.findAll();
		
	}
	public  Optional<Transaction> getTransactionById(Integer id){
		return repository.findById(id);
		
	}
	public Transaction createTransaction(int id1, int id2,Transaction transaction) {
		
	Optional<UserTable> user=	userRepository.findById(id1);
	Optional<Stock> stock=	stockRepository.findById(id2);
		
	UserTable user1=user.get();
	Stock stock1=stock.get();
	Transaction tran=new Transaction();
	tran.setUser(user1);
	tran.setStock(stock1);
	tran.setPrice(transaction.getPrice());
	tran.setQuantity(transaction.getQuantity());
	tran.setTransactionDate(transaction.getTransactionDate());
	tran.setTransactionType(transaction.getTransactionType());
		
		return repository.save(tran);
		
	}
	
	public Transaction updateTransaction(Integer id,Transaction transactionDetails) throws UserNotFoundException {
		Optional<Transaction> TransactionOptional=repository.findById(id);
		if(TransactionOptional.isPresent()) {
			Transaction existingTransaction=TransactionOptional.get();
			 existingTransaction.setUser(transactionDetails.getUser());
	            existingTransaction.setStock(transactionDetails.getStock());
	            existingTransaction.setTransactionType(transactionDetails.getTransactionType());
	            existingTransaction.setQuantity(transactionDetails.getQuantity());
	            existingTransaction.setPrice(transactionDetails.getPrice());
	            existingTransaction.setTransactionDate(transactionDetails.getTransactionDate());
	            // Update other properties as needed
	            return repository.save(existingTransaction);
			
		}
		else {
			
			throw new UserNotFoundException("invalid id");
			
		}
		
		
		
	}
	public void deleteTransaction(Integer id) {
		repository.deleteById(id);
	}


}
