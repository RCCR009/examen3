package com.cenfotec.examen3.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bill")
public class Bill {
	
	@Id
	private String id;
	private double amount;
	private LocalDate fecha;
	private String store;
	
	public Bill() {
		
	}

	public Bill(double amount, LocalDate fecha, String store) {
		super();
		this.amount = amount;
		this.fecha = fecha;
		this.store = store;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
