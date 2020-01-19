package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
	private int id_Patient;
	private String nom, premierPrenom, deuxiemePrenom, nomRue, numeroRue, codePostal, ville, mail, connu, remarque;
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
	
	public Patient( String nom, String premierPrenom, String deuxiemePrenom, String nomRue,
			String numeroRue, String codePostal, String ville, String mail, String connu, String remarque,
			Date dateDeNaissance, Classification classification) {
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

	public int getId_Patient() {
		return id_Patient;
	}

	public void setId_Patient(int id_Patient) {
		this.id_Patient = id_Patient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPremierPrenom() {
		return premierPrenom;
	}

	public void setPremierPrenom(String premierPrenom) {
		this.premierPrenom = premierPrenom;
	}

	public String getDeuxiemePrenom() {
		return deuxiemePrenom;
	}

	public void setDeuxiemePrenom(String deuxiemePrenom) {
		this.deuxiemePrenom = deuxiemePrenom;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getConnu() {
		return connu;
	}

	public void setConnu(String connu) {
		this.connu = connu;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Profession> getListProfessions() {
		return listProfessions;
	}

	public void setListProfessions(List<Profession> listProfessions) {
		this.listProfessions = listProfessions;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public List<Consultation> getListConsutations() {
		return listConsutations;
	}

	public void setListConsutations(List<Consultation> listConsutations) {
		this.listConsutations = listConsutations;
	}

	@Override
	public String toString() {
		return "Patient [nom=" + nom + ", premierPrenom=" + premierPrenom + ", deuxiemePrenom=" + deuxiemePrenom
				+ ", nomRue=" + nomRue + ", numeroRue=" + numeroRue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", mail=" + mail + ", connu=" + connu + ", remarque=" + remarque + ", dateDeNaissance="
				+ dateDeNaissance + ", classification=" + classification + "]";
	}
}
