package com.rhula.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	
	@Column(name="payment_date_time")
	private String date_time;
	
	@Column(name="payment_coust")
	private Double coust;
	
	@Column(name="car_idcar")
	private String idcar;
	
	@Column(name="passenger_idpassenger")
	private String idpassenger;
	
	@Column(name="payment_dataLog")
	private String dataLog;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public Double getCoust() {
		return coust;
	}

	public void setCoust(int coust) {
		this.coust = (double) coust;
	}

	public String getIdcar() {
		return idcar;
	}

	public void setIdcar(String idcar) {
		this.idcar = idcar;
	}

	public String getIdpassenger() {
		return idpassenger;
	}

	public void setIdpassenger(String idpassenger) {
		this.idpassenger = idpassenger;
	}

	public String getDataLog() {
		return dataLog;
	}

	public void setDataLog(String dataLog) {
		this.dataLog = dataLog;
	}
	
	

}
