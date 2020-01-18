package dao;

import java.sql.Connection;

import classes.Patient;

public class PatientDAO extends DAO<Patient> {

	public PatientDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Patient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Patient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Patient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Patient setPatient() {
		return null;
	}

}
