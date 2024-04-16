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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.service.StockService;
import com.vignesh.tradingApplication.service.UserNotFoundException;

@RestController
@RequestMapping("/stocks")
public class StockController {
    
	@Autowired
    private StockService stockService;
	
	 @RequestMapping("/add")
	    public ModelAndView index1() {
			return new ModelAndView("StockRegister");
	    	
	    }

    @GetMapping("/stocklist")
//    public ResponseEntity<List<Stock>> getAllStocks() {
//        List<Stock> stocks = stockService.getAllStock();
//        return new ResponseEntity<>(stocks, HttpStatus.OK);
//    }
    public ModelAndView stockList(Model model) {
    	List<Stock> stock=stockService.getAllStock();
    	ModelAndView mav=new ModelAndView("stocklist");
    	model.addAttribute("stocklist", stock);
    	return mav;
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Integer id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addstock")
//    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
//        Stock createdStock = stockService.createStock(stock);
//        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
//    }
    public ModelAndView createStock(@ModelAttribute Stock stock) {
    	ModelAndView mav=new ModelAndView("Trading");
    	mav.addObject(stockService.createStock(stock));
    	return mav;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable("id") Integer id, @RequestBody Stock stockDetails) throws UserNotFoundException {
        Stock updatedStock = stockService.updateStock(id, stockDetails);
        if (updatedStock != null) {
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable("id") Integer id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
