package com.cibtf.dao;

public class PublicacionesActiveDAO {
	private int eventoActive = 1;
	private int noticiaActive = 1;
	private int eventoActive2 = 1;
	private int noticiaActive2 = 1;
	
	public PublicacionesActiveDAO() {
		
	}

	public int getEventoActive() {
		return eventoActive;
	}

	public void setEventoActive() {
		eventoActive++;
	}

	public int getNoticiaActive() {
		return noticiaActive;
	}

	public void setNoticiaActive() {
		noticiaActive++;
	}

	public int getEventoActive2() {
		return eventoActive2;
	}

	public void setEventoActive2() {
		eventoActive2++;
	}

	public int getNoticiaActive2() {
		return noticiaActive2;
	}

	public void setNoticiaActive2() {
		noticiaActive2++;
	}
	
	
}
