package classes;

import java.util.Date;

public class Consultation {
	private float prix;
	private Date date;
	private Date dateArrivee;
	private Date dateFin;
	private int anxiete, id;
	private Reglement reglement;
	private Patient patient;

	public Consultation(float prix, Date date, Date dateArrivee, Date dateFin, int anxiete, int id, Reglement reglement,
			Patient patient) {
		this.prix = prix;
		this.date = date;
		this.dateArrivee = dateArrivee;
		this.dateFin = dateFin;
		this.anxiete = anxiete;
		this.id = id;
		this.reglement = reglement;
		this.patient = patient;
	}

	public Consultation(float prix, Date date, Date dateArrivee, Date dateFin, int anxiete, int id,
			Reglement reglement) {
		this.prix = prix;
		this.date = date;
		this.dateArrivee = dateArrivee;
		this.dateFin = dateFin;
		this.anxiete = anxiete;
		this.id = id;
		this.reglement = reglement;
	}

	public Consultation(float prix, Date date, Date dateArrivee, Date dateFin, int anxiete, Reglement reglement) {
		this.prix = prix;
		this.date = date;
		this.dateArrivee = dateArrivee;
		this.dateFin = dateFin;
		this.anxiete = anxiete;
		this.reglement = reglement;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getAnxiete() {
		return anxiete;
	}

	public void setAnxiete(int anxiete) {
		this.anxiete = anxiete;
	}

	public Reglement getReglement() {
		return reglement;
	}

	public void setReglement(Reglement reglement) {
		this.reglement = reglement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Consultation [prix=" + prix + ", date=" + date.toLocaleString() + ", dateArrivee=" + dateArrivee
				+ ", dateFin=" + dateFin.toLocaleString() + ", anxiete=" + anxiete + ", id=" + id + ", reglement="
				+ reglement + "]";
	}

}
