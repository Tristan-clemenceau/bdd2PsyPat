package classes;

import java.util.ArrayList;
import java.util.List;

public class Psy {
	private List<Patient> listPatients;
	private List<Consultation> listConsultations;
	
	public Psy() {
		listPatients = new ArrayList<Patient>();
		listConsultations = new ArrayList<Consultation>();
	}
	
	public void addPatient(Patient patient) {
		listPatients.add(patient);
	}
	
	public void addConsultation(Consultation consultation) {
		listConsultations.add(consultation);
	}

	public List<Patient> getListPatients() {
		return listPatients;
	}

	public void setListPatients(List<Patient> listPatients) {
		this.listPatients = listPatients;
	}

	public List<Consultation> getListConsultations() {
		return listConsultations;
	}

	public void setListConsultations(List<Consultation> listConsultations) {
		this.listConsultations = listConsultations;
	}
	
	public void dispPatient() {
		for (Patient patient : listPatients) {
			System.out.println(patient.toString());
		}	
	}
	
	public void dispConsultation() {
		for (Consultation consultation : listConsultations) {
			System.out.println(consultation.toString());
		}	
	}
	
	
}
