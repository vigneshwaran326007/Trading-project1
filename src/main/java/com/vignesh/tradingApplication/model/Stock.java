package com.vignesh.tradingApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="symbol")
	private String symbol;
	@Column(name="companyName")
	private String companyName;
	@Column(name="currentPrice")
	private double currentPrice;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setcurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Stock(Integer id, String symbol, String companyName, double currentPrice) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.companyName = companyName;
		this.currentPrice = currentPrice;
	}
	
	public Stock() {
		
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", symbol=" + symbol + ", companyName=" + companyName + ", currentPrice="
				+ currentPrice + "]";
	}

	
}
