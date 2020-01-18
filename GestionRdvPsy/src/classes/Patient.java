package classes;

import java.util.Date;
import java.util.List;

public class Patient {
	private int id_Patient;
	private String nom,premierPrenom,deuxiemePrenom,nomRue,numeroRue,codePostal,ville,mail,connu,remarque;
	private Date dateDeNaissance;
	private List<Profession> listProfessions;
	private Classification classification;
	private List<Consultation> listConsutations;
}
