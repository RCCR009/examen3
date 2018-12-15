package com.cenfotec.examen3.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight")
public class Flight {
	
	@Id
	private String id;
	private LocalDate date;
	private ArrayList<Package> packageList;
	
	public Flight() {
		this.packageList = new ArrayList<Package>();
	}
	
	public Flight(LocalDate date, ArrayList<Package> packageList) {
		super();
		this.date = date;
		this.packageList = packageList;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Package> getPackageList() {
		return packageList;
	}

	public void setPackageList(ArrayList<Package> packageList) {
		this.packageList = packageList;
	}
	
	public void addPackage(Package pack) {
		this.packageList.add(pack);
	}
	
}
