package com.cibtf.model;

public class Empresa {
	
	private int idUsuario;
	private int idEmpresa;
	private int statusUsuario = 0;
	private String correoUsuario;
	private String passUsuario;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String nombreEmpresa;
	private String telefonoEmpresa;
	private String correoEmpresa;
	private String calleEmpresa;
	private String noCalleEmpresa;
	private String coloniaEmpresa;
	private String cpEmpresa;
	private String paisEmpresa;
	private String estadoEmpresa;
	private String ciudadEmpresa;
	private String municipioEmpresa;
	private String paginaEmpresa;
	private String razonSocialEmpresa;
	private String rfcEmpresa;

	
	public Empresa() {
		
	}


	public Empresa(int idUsuario, int idEmpresa, int statusUsuario, String correoUsuario, String passUsuario,
			String nombreUsuario, String apellidosUsuario, String nombreEmpresa, String telefonoEmpresa,
			String correoEmpresa, String calleEmpresa, String noCalleEmpresa, String coloniaEmpresa, String cpEmpresa,
			String paisEmpresa, String estadoEmpresa, String ciudadEmpresa, String municipioEmpresa,
			String paginaEmpresa, String razonSocialEmpresa, String rfcEmpresa) {
		super();
		this.idUsuario = idUsuario;
		this.idEmpresa = idEmpresa;
		this.statusUsuario = statusUsuario;
		this.correoUsuario = correoUsuario;
		this.passUsuario = passUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.calleEmpresa = calleEmpresa;
		this.noCalleEmpresa = noCalleEmpresa;
		this.coloniaEmpresa = coloniaEmpresa;
		this.cpEmpresa = cpEmpresa;
		this.paisEmpresa = paisEmpresa;
		this.estadoEmpresa = estadoEmpresa;
		this.ciudadEmpresa = ciudadEmpresa;
		this.municipioEmpresa = municipioEmpresa;
		this.paginaEmpresa = paginaEmpresa;
		this.razonSocialEmpresa = razonSocialEmpresa;
		this.rfcEmpresa = rfcEmpresa;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public int getStatusUsuario() {
		return statusUsuario;
	}


	public void setStatusUsuario(int statusUsuario) {
		this.statusUsuario = statusUsuario;
	}


	public String getCorreoUsuario() {
		return correoUsuario;
	}


	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}


	public String getPassUsuario() {
		return passUsuario;
	}


	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
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


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}


	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}


	public String getCorreoEmpresa() {
		return correoEmpresa;
	}


	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}


	public String getCalleEmpresa() {
		return calleEmpresa;
	}


	public void setCalleEmpresa(String calleEmpresa) {
		this.calleEmpresa = calleEmpresa;
	}


	public String getNoCalleEmpresa() {
		return noCalleEmpresa;
	}


	public void setNoCalleEmpresa(String noCalleEmpresa) {
		this.noCalleEmpresa = noCalleEmpresa;
	}


	public String getColoniaEmpresa() {
		return coloniaEmpresa;
	}


	public void setColoniaEmpresa(String coloniaEmpresa) {
		this.coloniaEmpresa = coloniaEmpresa;
	}


	public String getCpEmpresa() {
		return cpEmpresa;
	}


	public void setCpEmpresa(String cpEmpresa) {
		this.cpEmpresa = cpEmpresa;
	}


	public String getPaisEmpresa() {
		return paisEmpresa;
	}


	public void setPaisEmpresa(String paisEmpresa) {
		this.paisEmpresa = paisEmpresa;
	}


	public String getEstadoEmpresa() {
		return estadoEmpresa;
	}


	public void setEstadoEmpresa(String estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}


	public String getCiudadEmpresa() {
		return ciudadEmpresa;
	}


	public void setCiudadEmpresa(String ciudadEmpresa) {
		this.ciudadEmpresa = ciudadEmpresa;
	}


	public String getMunicipioEmpresa() {
		return municipioEmpresa;
	}


	public void setMunicipioEmpresa(String municipioEmpresa) {
		this.municipioEmpresa = municipioEmpresa;
	}


	public String getPaginaEmpresa() {
		return paginaEmpresa;
	}


	public void setPaginaEmpresa(String paginaEmpresa) {
		this.paginaEmpresa = paginaEmpresa;
	}


	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}


	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}


	public String getRfcEmpresa() {
		return rfcEmpresa;
	}


	public void setRfcEmpresa(String rfcEmpresa) {
		this.rfcEmpresa = rfcEmpresa;
	}


	@Override
	public String toString() {
		return "Empresa [idUsuario=" + idUsuario + ", idEmpresa=" + idEmpresa + ", statusUsuario=" + statusUsuario
				+ ", correoUsuario=" + correoUsuario + ", passUsuario=" + passUsuario + ", nombreUsuario="
				+ nombreUsuario + ", apellidosUsuario=" + apellidosUsuario + ", nombreEmpresa=" + nombreEmpresa
				+ ", telefonoEmpresa=" + telefonoEmpresa + ", correoEmpresa=" + correoEmpresa + ", calleEmpresa="
				+ calleEmpresa + ", noCalleEmpresa=" + noCalleEmpresa + ", coloniaEmpresa=" + coloniaEmpresa
				+ ", cpEmpresa=" + cpEmpresa + ", paisEmpresa=" + paisEmpresa + ", estadoEmpresa=" + estadoEmpresa
				+ ", ciudadEmpresa=" + ciudadEmpresa + ", municipioEmpresa=" + municipioEmpresa + ", paginaEmpresa="
				+ paginaEmpresa + ", razonSocialEmpresa=" + razonSocialEmpresa + ", rfcEmpresa=" + rfcEmpresa + "]";
	}

	
	
	
	
}
