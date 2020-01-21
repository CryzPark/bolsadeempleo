package com.cibtf.model;

public class Perfil {
	private int idUsuario;
	private String rolUsuario;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String correoUsuario;
	private String nombreEmpresaUsuario;
	private String nombreUniversidadUsuario;
	private String telefonoEmpresaUsuario;
	private String telefonoUniversidadUsuario;
	private String correoEmpresaUsuario;
	private String correoUniversidadUsuario;

	public Perfil() {
		
	}

	public Perfil(int idUsuario, String rolUsuario, String nombreUsuario, String apellidosUsuario, String correoUsuario,
			String nombreEmpresaUsuario, String nombreUniversidadUsuario, String telefonoEmpresaUsuario,
			String telefonoUniversidadUsuario, String correoEmpresaUsuario, String correoUniversidadUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.rolUsuario = rolUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.correoUsuario = correoUsuario;
		this.nombreEmpresaUsuario = nombreEmpresaUsuario;
		this.nombreUniversidadUsuario = nombreUniversidadUsuario;
		this.telefonoEmpresaUsuario = telefonoEmpresaUsuario;
		this.telefonoUniversidadUsuario = telefonoUniversidadUsuario;
		this.correoEmpresaUsuario = correoEmpresaUsuario;
		this.correoUniversidadUsuario = correoUniversidadUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getNombreEmpresaUsuario() {
		return nombreEmpresaUsuario;
	}

	public void setNombreEmpresaUsuario(String nombreEmpresaUsuario) {
		this.nombreEmpresaUsuario = nombreEmpresaUsuario;
	}

	public String getNombreUniversidadUsuario() {
		return nombreUniversidadUsuario;
	}

	public void setNombreUniversidadUsuario(String nombreUniversidadUsuario) {
		this.nombreUniversidadUsuario = nombreUniversidadUsuario;
	}

	public String getTelefonoEmpresaUsuario() {
		return telefonoEmpresaUsuario;
	}

	public void setTelefonoEmpresaUsuario(String telefonoEmpresaUsuario) {
		this.telefonoEmpresaUsuario = telefonoEmpresaUsuario;
	}

	public String getTelefonoUniversidadUsuario() {
		return telefonoUniversidadUsuario;
	}

	public void setTelefonoUniversidadUsuario(String telefonoUniversidadUsuario) {
		this.telefonoUniversidadUsuario = telefonoUniversidadUsuario;
	}

	public String getCorreoEmpresaUsuario() {
		return correoEmpresaUsuario;
	}

	public void setCorreoEmpresaUsuario(String correoEmpresaUsuario) {
		this.correoEmpresaUsuario = correoEmpresaUsuario;
	}

	public String getCorreoUniversidadUsuario() {
		return correoUniversidadUsuario;
	}

	public void setCorreoUniversidadUsuario(String correoUniversidadUsuario) {
		this.correoUniversidadUsuario = correoUniversidadUsuario;
	}

	@Override
	public String toString() {
		return "Perfil [idUsuario=" + idUsuario + ", rolUsuario=" + rolUsuario + ", nombreUsuario=" + nombreUsuario
				+ ", apellidosUsuario=" + apellidosUsuario + ", correoUsuario=" + correoUsuario
				+ ", nombreEmpresaUsuario=" + nombreEmpresaUsuario + ", nombreUniversidadUsuario="
				+ nombreUniversidadUsuario + ", telefonoEmpresaUsuario=" + telefonoEmpresaUsuario
				+ ", telefonoUniversidadUsuario=" + telefonoUniversidadUsuario + ", correoEmpresaUsuario="
				+ correoEmpresaUsuario + ", correoUniversidadUsuario=" + correoUniversidadUsuario + "]";
	}
	
	
	
}
