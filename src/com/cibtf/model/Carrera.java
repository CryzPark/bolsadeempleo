package com.cibtf.model;

public class Carrera {
	private int idCarrera;
	private String nombreCarrera;
	
	public Carrera() {
		
	}
	
	
	public Carrera(int idCarrera, String nombreCarrera) {
		super();
		this.idCarrera = idCarrera;
		this.nombreCarrera = nombreCarrera;
	}



	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	@Override
	public String toString() {
		return "carrera [idCarrera=" + idCarrera + ", nombreCarrera=" + nombreCarrera + "]";
	}

}
