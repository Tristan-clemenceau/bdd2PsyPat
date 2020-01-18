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
}
