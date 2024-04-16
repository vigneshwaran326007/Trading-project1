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

import com.vignesh.tradingApplication.model.MarketData;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.service.MarketDataService;

@RestController
@RequestMapping("/marketdata")
public class MarketDataController {
    @Autowired
    private MarketDataService marketDataService;
    
    @RequestMapping("/add")
    	 public ModelAndView index1() {
    			return new ModelAndView("market_data_build_report");
    	    	
    	    }
    

    @GetMapping("/marketlist")
//    public ResponseEntity<List<MarketData>> getAllMarketData() {
//        List<MarketData> marketData = marketDataService.getAllMarketData();
//        return new ResponseEntity<>(marketData, HttpStatus.OK);
//    }
    public ModelAndView getAllMarketData(Model model) {
    	 List<MarketData> marketData = marketDataService.getAllMarketData();
    	 ModelAndView mav=new ModelAndView("marketlist");
    	 model.addAttribute("marketlist", marketData);
    	 return mav;
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketData> getMarketDataById(@PathVariable("id") Integer id) {
        Optional<MarketData> marketData = marketDataService.getMarketDataById(id);
        return marketData.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addmarket")
//    public ResponseEntity<MarketData> createMarketData(@PathVariable int id1, @RequestBody MarketData marketData) {
//        MarketData createdMarketData = marketDataService.createMarketData(id1,marketData);
//        return new ResponseEntity<>(createdMarketData, HttpStatus.CREATED);
//    }
    
    
    public ModelAndView createMarketData(@RequestParam int stock, @ModelAttribute MarketData data) {
    	ModelAndView mav=new ModelAndView("Trading");
    	mav.addObject(marketDataService.createMarketData(stock,data));
    	return mav;
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<MarketData> updateMarketData(@PathVariable("id") Integer id, @RequestBody MarketData marketDataDetails) {
        MarketData updatedMarketData = marketDataService.updateMarketData(id, marketDataDetails);
        if (updatedMarketData != null) {
            return new ResponseEntity<>(updatedMarketData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarketData(@PathVariable("id") Integer id) {
        marketDataService.deleteMarketData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
