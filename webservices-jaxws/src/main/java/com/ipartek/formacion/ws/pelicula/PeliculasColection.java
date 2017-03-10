package com.ipartek.formacion.ws.pelicula;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import com.ipartek.formacion.pojo.Pelicula;

public class PeliculasColection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Set<Pelicula> peliculas;
	String mensaje;
	
	
	public PeliculasColection() {
		super();
		this.peliculas = new TreeSet<Pelicula>();
		this.mensaje = "";
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	
}
