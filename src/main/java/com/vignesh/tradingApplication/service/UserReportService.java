package com.vignesh.tradingApplication.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.repository.UserRepository;

@Service
public class UserReportService {
	
	@Autowired
	public UserRepository repository;
	public List<UserTable> userReport(Date date1,Date date2){
	List<UserTable> list=	repository.findByDateBetween(date1, date2);
	return list;
	}
	

}
