package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
	private int id_Patient;
	private String nom,premierPrenom,deuxiemePrenom,nomRue,numeroRue,codePostal,ville,mail,connu,remarque;
	private Date dateDeNaissance;
	private List<Profession> listProfessions;
	private Classification classification;
	private List<Consultation> listConsutations;
	public Patient(int id_Patient, String nom, String premierPrenom, String deuxiemePrenom, String nomRue,
			String numeroRue, String codePostal, String ville, String mail, String connu, String remarque,
			Date dateDeNaissance, Classification classification) {
		this.id_Patient = id_Patient;
		this.nom = nom;
		this.premierPrenom = premierPrenom;
		this.deuxiemePrenom = deuxiemePrenom;
		this.nomRue = nomRue;
		this.numeroRue = numeroRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.connu = connu;
		this.remarque = remarque;
		this.dateDeNaissance = dateDeNaissance;
		this.listProfessions = new ArrayList<Profession>();
		this.classification = classification;
		this.listConsutations = new ArrayList<Consultation>();
	}
	
	public void addProfession(Profession profession) {
		listProfessions.add(profession);
	}
	
	public void addConsultation(Consultation consultation) {
		listConsutations.add(consultation);
	}

	@Override
	public String toString() {
		return "Patient [id_Patient=" + id_Patient + ", nom=" + nom + ", premierPrenom=" + premierPrenom
				+ ", deuxiemePrenom=" + deuxiemePrenom + ", nomRue=" + nomRue + ", numeroRue=" + numeroRue
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", mail=" + mail + ", connu=" + connu
				+ ", remarque=" + remarque + ", dateDeNaissance=" + dateDeNaissance + ", classification="
				+ classification + "]";
	}
	
	
}
