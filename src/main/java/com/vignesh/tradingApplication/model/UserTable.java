package com.vignesh.tradingApplication.model;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usertable")
public class UserTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "username")
	private String username ;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "role")
	private String role;
	@Column(name = "accountBalance")
	private double accountBalance;
	@Column(name = "registrationDate")
	private Date registrationDate;
	
	public UserTable() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UserTable(Integer id, String username, String password, String email, String role, double accountBalance,
			Date registrationDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.accountBalance = accountBalance;
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "UserTable [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", accountBalance=" + accountBalance + ", registrationDate=" + registrationDate
				+ "]";
	}
	
	
	
}
