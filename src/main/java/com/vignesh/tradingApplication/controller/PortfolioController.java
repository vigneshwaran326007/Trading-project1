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

import com.vignesh.tradingApplication.model.Portfolio;
import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.service.PortfolioService;
import com.vignesh.tradingApplication.service.UserNotFoundException;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    
    
    @RequestMapping("/add")
	 public ModelAndView index1() {
			return new ModelAndView("Portfolio_Report_Build");
	    	
	    }
    

    @GetMapping("/portfoliolist")
//    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
//        List<Portfolio> portfolios = portfolioService.getAllPortfolios();
//        return new ResponseEntity<>(portfolios, HttpStatus.OK);
//    }
    public ModelAndView getAllPortfolios(Model model) {
    	
    	List<Portfolio> portfolios = portfolioService.getAllPortfolios();
    	ModelAndView mav=new ModelAndView("portlist");
    	model.addAttribute("portlist", portfolios);
    	return mav;
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable("id") Integer id) {
        Optional<Portfolio> portfolio = portfolioService.getPortfolioById(id);
        return portfolio.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addportfolio")
//    public ResponseEntity<Portfolio> createPortfolio(@PathVariable int id1,@PathVariable int id2, @RequestBody Portfolio portfolio) {
//        Portfolio createdPortfolio = portfolioService.createPortfolio(id1,id2,portfolio);
//        return new ResponseEntity<>(createdPortfolio, HttpStatus.CREATED);
//    }
    
    
    public ModelAndView createportfolio(@RequestParam int user, @RequestParam int stock,   @ModelAttribute Portfolio port) {
    	ModelAndView mav=new ModelAndView("Trading");
    	mav.addObject(portfolioService.createPortfolio(user, stock, port));
    	return mav;
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable("id") Integer id, @RequestBody Portfolio portfolioDetails) throws UserNotFoundException {
        Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolioDetails);
        if (updatedPortfolio != null) {
            return new ResponseEntity<>(updatedPortfolio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable("id") Integer id) {
        portfolioService.deletePortfolio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
