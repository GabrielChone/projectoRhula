package com.rhula.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name="car")


public class Car implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	@Audited
	@Column(name="owner_idowner")
	private int idowner;
	@Audited
	@Column(name="rote_idrote")
	private int idrote;
	@Audited
	@Column(name="car_type")
	private int type;
	@Audited
	@Column(name="car_dateLog")
	private String dateLog;
	@Audited
	@Column(name="car_chauffer_name")
	private String chauffer_name;
	@Audited
	@Column(name="car_chauffer_BI")
	private String bi;
	@Audited
	@Column(name="car_chauffer_Balance")
	private Long balance;
	@Audited
	@Column(name="car_registration")
	private String registration;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdowner() {
		return idowner;
	}

	public void setIdowner(int idowner) {
		this.idowner = idowner;
	}

	public int getIdrote() {
		return idrote;
	}

	public void setIdrote(int idrote) {
		this.idrote = idrote;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDateLog() {
		return dateLog;
	}

	public void setDateLog(String dateLog) {
		this.dateLog = dateLog;
	}

	public String getChauffer_name() {
		return chauffer_name;
	}

	public void setChauffer_name(String chauffer_name) {
		this.chauffer_name = chauffer_name;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
