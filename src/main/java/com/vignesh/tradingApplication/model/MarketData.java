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
@Table(name = "marketdata")
public class MarketData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "stock_id", nullable = false)
	private Stock stock;
	@Column(name="date", nullable = false)
	private Date date;
	@Column(name="highPrice", nullable = false)
	private double highPrice;
	@Column(name="lowPrice", nullable = false)
	private double lowPrice;
	@Column(name="openPrice", nullable = false)
	private double openPrice;
	@Column(name="closePrice", nullable = false)
	private double closePrice;
	@Column(name="volume", nullable = false)
	private long volume;
	public Integer getId() {
		return id;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	public MarketData(Integer id, Stock stock, Date date, double highPrice, double lowPrice, double closePrice,
			long volume) {
		super();
		this.id = id;
		this.stock = stock;
		this.date = date;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
	}
	public MarketData(int i, String string, double d, double e) {
		// TODO Auto-generated constructor stub
	}
	public MarketData(Object object, String string, double d, double e) {
		// TODO Auto-generated constructor stub
	}
	public MarketData() {
		// TODO Auto-generated constructor stub
	}
	

}
