package com.cenfotec.examen3.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "package")
public class Package {

	@Id
    String id;
	Boolean prealerted;
	Account receiver;
	LocalDate dateReceived;
	Courier courier;
	Bill bill;
	
	public Package() {
		
	}
	
	public Package(Boolean pprealerted, Account preceiver, LocalDate pdateReceived, Courier pcourier, Bill pbill) {
		this.prealerted = pprealerted;
		this.receiver = preceiver;
		this.dateReceived = pdateReceived;
		this.courier = pcourier;
		this.bill = pbill;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getPrealerted() {
		return prealerted;
	}
	public void setPrealerted(Boolean prealerted) {
		this.prealerted = prealerted;
	}
	public Account getReceiver() {
		return receiver;
	}
	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	public LocalDate getDateReceived() {
		return dateReceived;
	}
	public void setFechaRecibido(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}
	public Courier getCourier() {
		return courier;
	}
	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
}
