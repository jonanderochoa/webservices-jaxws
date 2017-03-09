package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class Genero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	
	public Genero() {
		super();
		this.nombre = "Comedia";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
