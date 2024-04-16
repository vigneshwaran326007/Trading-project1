package com.vignesh.tradingApplication.model;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserTable user;
	@ManyToOne
	@JoinColumn(name ="stock_id", nullable = false )
	private Stock stock;
	@Column(name = "transactionType", nullable = false)
	private String transactionType;
	@Column(name = "quantity", nullable = false)
	private int quantity;
	@Column(name = "price", nullable = false)
	private double price;
	@Column(name = "transactionDate", nullable = false)
	private Date transactionDate;
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
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Transaction(Integer id, UserTable user, Stock stock, String transactionType, int quantity, double price,
			Date transactionDate) {
		super();
		this.id = id;
		this.user = user;
		this.stock = stock;
		this.transactionType = transactionType;
		this.quantity = quantity;
		this.price = price;
		this.transactionDate = transactionDate;
	}
	
public Transaction() {
	// TODO Auto-generated constructor stub
}
}
