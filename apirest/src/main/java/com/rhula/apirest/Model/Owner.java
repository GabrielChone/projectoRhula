package com.rhula.apirest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="owner")

public class Owner implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	@Email
	private String email;
	@NotNull
	@Size(min=5,max=18)
	
	@Column(name="owner_name")
	private String name;
	
	@Column(name="owner_cellphone1")
	private Long cellphone1;
	
	protected Owner() {
	}
	
	
	@Column(name="owner_cellphone2")
	private Long cellphone2;
	
	@Column(name="owner_nuit")
	private Long nuit;
	
	@Column(name="owner_balance")
	private Long balance;
	
}
