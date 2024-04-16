package com.vignesh.tradingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vignesh.tradingApplication.model.Portfolio;
import com.vignesh.tradingApplication.service.StockUserReportService;

@RestController
@RequestMapping("/report")
public class StockUserReportController {

	@Autowired
	private StockUserReportService service;
	
	   @RequestMapping("/stock")
	    public ModelAndView index() {
			return new ModelAndView("StockUserReport");
	    	
	    }
	
	
	//@GetMapping("/stockreport/{id1}/{id2}")
	@GetMapping("/stockuserreport")
//	public List<Portfolio> stockReport( @PathVariable Integer id1){
//		//List<Portfolio> user= service.userStock(id1,id2);
//		List<Portfolio> user= service.userStock(id1);
//		return user;
//		
//	}
	
	public ModelAndView stockReport(@RequestParam Integer id, Model model) {
		
		List<Portfolio> user= service.userStock(id);	
		ModelAndView mav=new ModelAndView("portlist");
		model.addAttribute("portlist", user);
		return mav;
		
	}
	
	
}
