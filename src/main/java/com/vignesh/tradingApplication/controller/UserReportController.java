package com.vignesh.tradingApplication.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.service.UserReportService;

@RestController
@RequestMapping("/report")
public class UserReportController {
	

	@Autowired
	private UserReportService reportService;
	@RequestMapping("/generate")
	public ModelAndView index() {
		return new ModelAndView("UserReport");
    	
    }
	
	@GetMapping("/userreport")
//	public List<UserTable> userReport(@PathVariable Date date1, @PathVariable Date date2){
//		
//		List<UserTable> list=reportService.userReport(date1, date2);
//		return list;
//		
//	}
	public ModelAndView userReport(@RequestParam Date date1,@RequestParam Date date2, Model model ) {
		List<UserTable> report=reportService.userReport(date1, date2);
		ModelAndView mav=new ModelAndView("UserReportList");
		model.addAttribute("userReport", report);
		return mav;
	}
}
