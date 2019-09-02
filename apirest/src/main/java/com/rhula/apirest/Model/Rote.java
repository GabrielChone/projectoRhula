package com.rhula.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rote")
public class Rote implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	
	@Column(name="rote_name")
	private String name;
	
	@Column(name="terminal_rote_idterminal_rote")
	private int idterminal_rote;
	
	@Column(name="terminalA")
	private String terminalA;
	
	@Column(name="terminalB")
	private String terminalB;
	
	@Column(name="terminalA_latitude_longitude")
	private String terminalA_latitude_longitude;
	
	@Column(name="terminalB_latitude_longitude")
	private String terminalB_latitude_longitude;

	@Column(name="car_dateLog")
	private String dataLog;
	
	@Column(name="rote_city")
	private String city;
	
	@Column(name="rote_distrito")
	private String distrito;

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

	public int getIdterminal_rote() {
		return idterminal_rote;
	}

	public void setIdterminal_rote(int idterminal_rote) {
		this.idterminal_rote = idterminal_rote;
	}

	public String getTerminalA() {
		return terminalA;
	}

	public void setTerminalA(String terminalA) {
		this.terminalA = terminalA;
	}

	public String getTerminalB() {
		return terminalB;
	}

	public void setTerminalB(String terminalB) {
		this.terminalB = terminalB;
	}

	public String getTerminalA_latitude_longitude() {
		return terminalA_latitude_longitude;
	}

	public void setTerminalA_latitude_longitude(String terminalA_latitude_longitude) {
		this.terminalA_latitude_longitude = terminalA_latitude_longitude;
	}

	public String getTerminalB_latitude_longitude() {
		return terminalB_latitude_longitude;
	}

	public void setTerminalB_latitude_longitude(String terminalB_latitude_longitude) {
		this.terminalB_latitude_longitude = terminalB_latitude_longitude;
	}

	public String getDataLog() {
		return dataLog;
	}

	public void setDataLog(String dataLog) {
		this.dataLog = dataLog;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
}
