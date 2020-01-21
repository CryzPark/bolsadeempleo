package com.cibtf.model;

import java.io.InputStream;


public class Noticia {
	private int idNoticia;
	private int idUsuario;
	private int statusNoticia;
	private String nombreUsuario;
	private String universidadUsuario;
	private String tituloNoticia;
	private String descripcionNoticia;
	private String fechaNoticia;
	private InputStream imagenNoticia;
	
	public Noticia() {
		
	}

	public Noticia(int idNoticia, int idUsuario, int statusNoticia, String nombreUsuario, String universidadUsuario,
			String tituloNoticia, String descripcionNoticia, String fechaNoticia, InputStream imagenNoticia) {
		super();
		this.idNoticia = idNoticia;
		this.idUsuario = idUsuario;
		this.statusNoticia = statusNoticia;
		this.nombreUsuario = nombreUsuario;
		this.universidadUsuario = universidadUsuario;
		this.tituloNoticia = tituloNoticia;
		this.descripcionNoticia = descripcionNoticia;
		this.fechaNoticia = fechaNoticia;
		this.imagenNoticia = imagenNoticia;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getStatusNoticia() {
		return statusNoticia;
	}

	public void setStatusNoticia(int statusNoticia) {
		this.statusNoticia = statusNoticia;
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

	public String getTituloNoticia() {
		return tituloNoticia;
	}

	public void setTituloNoticia(String tituloNoticia) {
		this.tituloNoticia = tituloNoticia;
	}

	public String getDescripcionNoticia() {
		return descripcionNoticia;
	}

	public void setDescripcionNoticia(String descripcionNoticia) {
		this.descripcionNoticia = descripcionNoticia;
	}

	public String getFechaNoticia() {
		return fechaNoticia;
	}

	public void setFechaNoticia(String fechaNoticia) {
		this.fechaNoticia = fechaNoticia;
	}

	public InputStream getImagenNoticia() {
		return imagenNoticia;
	}

	public void setImagenNoticia(InputStream imagenNoticia) {
		this.imagenNoticia = imagenNoticia;
	}

	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", idUsuario=" + idUsuario + ", statusNoticia=" + statusNoticia
				+ ", nombreUsuario=" + nombreUsuario + ", universidadUsuario=" + universidadUsuario + ", tituloNoticia="
				+ tituloNoticia + ", descripcionNoticia=" + descripcionNoticia + ", fechaNoticia=" + fechaNoticia
				+ ", imagenNoticia=" + imagenNoticia + "]";
	}
	
	
	
}
