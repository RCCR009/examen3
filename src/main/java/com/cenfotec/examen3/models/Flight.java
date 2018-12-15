package com.cenfotec.examen3.models;

import java.awt.List;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight")
public class Flight {
	private LocalDate date;
	private List packageList;
	
	public Flight() {
		
	}
	
	public Flight(LocalDate date, List packageList) {
		super();
		this.date = date;
		this.packageList = packageList;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List getPackageList() {
		return packageList;
	}

	public void setPackageList(List packageList) {
		this.packageList = packageList;
	}
	
}
