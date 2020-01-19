package classes;

import java.util.Date;

public class Profession {
	private String nom;
	private Date date;
	
	public Profession(String nom,Date date) {
		this.nom = nom;
		this.date = date;
	}
	
	public Profession(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
