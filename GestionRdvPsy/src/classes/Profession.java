package classes;

import java.util.Date;

public class Profession {
	private String nom;
	private Date date;
	private int id_Profession;

	public Profession(String nom, Date date, int id_Profession) {
		this.nom = nom;
		this.date = date;
		this.id_Profession = id_Profession;
	}

	public Profession(String nom, Date date) {
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

	public int getId_Profession() {
		return id_Profession;
	}

	public void setId_Profession(int id_Profession) {
		this.id_Profession = id_Profession;
	}

	@Override
	public String toString() {
		return "Profession [nom=" + nom + ", date=" + date + "]";
	}

}
