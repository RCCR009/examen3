package com.cenfotec.examen3.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courier")
public class Courier {
	
	@Id
    String id;
	String nombre;
	
	public Courier() {
		
	}
	
	public Courier(String pnombre) {
		this.nombre = pnombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
