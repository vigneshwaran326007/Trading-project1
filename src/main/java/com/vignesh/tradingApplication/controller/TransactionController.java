package com.vignesh.tradingApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vignesh.tradingApplication.model.Transaction;
import com.vignesh.tradingApplication.service.TransactionService;
import com.vignesh.tradingApplication.service.UserNotFoundException;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    
    
    @RequestMapping("/add")
	 public ModelAndView index1() {
			return new ModelAndView("TransactionReportBuilder");
	    	
	    }
    

    @GetMapping("/transactionlist")
//    public ResponseEntity<List<Transaction>> getAllTransactions() {
//        List<Transaction> transactions = transactionService.getAllTransaction();
//        return new ResponseEntity<>(transactions, HttpStatus.OK);
//    }
    public ModelAndView translist(Model model) {
    List<Transaction> trans=transactionService.getAllTransaction();
    ModelAndView mav=new ModelAndView("translist");
    model.addAttribute("translist", trans);
    return mav;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Integer id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addtransaction")
//    public ResponseEntity<Transaction> createTransaction(@PathVariable int id1,@PathVariable int id2,  @RequestBody Transaction transaction) {
//        Transaction createdTransaction = transactionService.createTransaction(id1,id2,transaction);
//        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
//    }
    
    public ModelAndView createtransaction(@RequestParam int user, @RequestParam int stock,   @ModelAttribute Transaction tran) {
    	ModelAndView mav=new ModelAndView("Trading");
    	mav.addObject(transactionService.createTransaction(user, stock, tran));
    	return mav;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Integer id, @RequestBody Transaction transactionDetails) throws UserNotFoundException {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDetails);
        if (updatedTransaction != null) {
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Integer id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
