package com.cibtf.model;

import java.io.InputStream;


public class Evento {
	private int idEvento;
	private int idUsuario;
	private int statusEvento;
	private String nombreUsuario;
	private String universidadUsuario;
	private String tituloEvento;
	private String descripcionEvento;
	private String fechaEvento;
	private InputStream imagenEvento;
	
	public Evento() {
		
	}

	public Evento(int idEvento, int idUsuario, int statusEvento, String nombreUsuario, String universidadUsuario,
			String tituloEvento, String descripcionEvento, String fechaEvento, InputStream imagenEvento) {
		super();
		this.idEvento = idEvento;
		this.idUsuario = idUsuario;
		this.statusEvento = statusEvento;
		this.nombreUsuario = nombreUsuario;
		this.universidadUsuario = universidadUsuario;
		this.tituloEvento = tituloEvento;
		this.descripcionEvento = descripcionEvento;
		this.fechaEvento = fechaEvento;
		this.imagenEvento = imagenEvento;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getStatusEvento() {
		return statusEvento;
	}

	public void setStatusEvento(int statusEvento) {
		this.statusEvento = statusEvento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getUniversidadUsuario() {
		return universidadUsuario;
	}

	public void setUniversidadUsuario(String universidadUsuario) {
		this.universidadUsuario = universidadUsuario;
	}

	public String getTituloEvento() {
		return tituloEvento;
	}

	public void setTituloEvento(String tituloEvento) {
		this.tituloEvento = tituloEvento;
	}

	public String getDescripcionEvento() {
		return descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public InputStream getImagenEvento() {
		return imagenEvento;
	}

	public void setImagenEvento(InputStream imagenEvento) {
		this.imagenEvento = imagenEvento;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", idUsuario=" + idUsuario + ", statusEvento=" + statusEvento
				+ ", nombreUsuario=" + nombreUsuario + ", universidadUsuario=" + universidadUsuario + ", tituloEvento="
				+ tituloEvento + ", descripcionEvento=" + descripcionEvento + ", fechaEvento=" + fechaEvento
				+ ", imagenEvento=" + imagenEvento + "]";
	}
	
	
	
}
