package com.cibtf.model;

public class VacanteCarrera {

	private int idVacante;
	private int idCarrera;
	
	public VacanteCarrera() {
		
	}
	
	
	public VacanteCarrera(int idVacante, int idCarrera) {
		super();
		this.idVacante = idVacante;
		this.idCarrera = idCarrera;
	}


	public int getIdVacante() {
		return idVacante;
	}


	public void setIdVacante(int idVacante) {
		this.idVacante = idVacante;
	}


	public int getIdCarrera() {
		return idCarrera;
	}


	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}


	@Override
	public String toString() {
		return "VacanteCarrera [idVacante=" + idVacante + ", idCarrera=" + idCarrera + "]";
	}
	
	
	
	
	
	
}
