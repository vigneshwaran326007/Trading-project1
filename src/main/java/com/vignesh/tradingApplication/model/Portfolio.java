package com.vignesh.tradingApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private UserTable user;
	@ManyToOne
	@JoinColumn(name = "stock_id" ,nullable = false)
	private Stock stock;
	@Column(name = "quantity", nullable = false)
	private int quantity;
	@Column(name = "averagePrice", nullable = false)
	private double averagePrice;
	@Column(name = "totalInvestment", nullable = false)
	private double totalInvestment;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserTable getUser() {
		return user;
	}
	public void setUser(UserTable user) {
		this.user = user;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public double getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	public Portfolio(Integer id, UserTable user, Stock stock, int quantity, double averagePrice,
			double totalInvestment) {
		super();
		this.id = id;
		this.user = user;
		this.stock = stock;
		this.quantity = quantity;
		this.averagePrice = averagePrice;
		this.totalInvestment = totalInvestment;
	}
	public Portfolio(int i, String string, int j, double d, double e) {
		// TODO Auto-generated constructor stub
	}
	public Portfolio(Object object, String string, int i, double d, double e) {
		// TODO Auto-generated constructor stub
	}
	public Portfolio() {
		// TODO Auto-generated constructor stub
	}
	
	
}
