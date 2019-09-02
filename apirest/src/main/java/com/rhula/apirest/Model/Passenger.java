package com.rhula.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")

public class Passenger implements Serializable {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	
	private static final long serialVersionUID = 1L;

	@Column(name="passenger_name")
	private String name;
	
	@Column(name="passenger_cellphone")
	private String cellphone;
	
	@Column(name="passenger_email")
	private String email;
	
	@Column(name="passenger_password")
	private String password;

	@Column(name="passenger_balance")
	private String balance;
	
	@Column(name="passenger_dataLog")
	private String datalog;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getDatalog() {
		return datalog;
	}

	public void setDatalog(String datalog) {
		this.datalog = datalog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
