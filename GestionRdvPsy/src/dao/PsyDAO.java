package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Classification;
import classes.Consultation;
import classes.Patient;
import classes.Profession;
import classes.Psy;

public class PsyDAO extends DAO<Psy> {

	public PsyDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Psy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Psy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Psy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Psy find(int id) {
		// TODO Auto-generated method stub
		Psy psy = new Psy();

		/* PreparedStatement */
		String sqlRequete = "SELECT * FROM patient";
		String sqlRequete02 = "SELECT c.prix,c.dateconsultation,c.datearrivee,c.datefin,c.anxiete,c.idconsultation,c.idreglement,p.idpatient FROM CONSULTATION C , PATIENT P WHERE C.IDCONSULTATION = P.IDCONSULTATION";
		/* VAR */
		PatientDAO patientDao = null;
		ConsultationDAO consultationDao = null;
		ClassificationDAO classificationDao = null;
		ReglementDAO reglement = null;
		Patient patient = null;
		Consultation consultation = null;
		Classification classification = null;

		try {
			/*Remplir liste Patients*/
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);

			ResultSet rs = pst.executeQuery();
			patientDao = new PatientDAO(this.getConnect());
			classificationDao = new ClassificationDAO(this.getConnect());
			while (rs.next()) {
				patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getDate(5), classificationDao.find(rs.getInt(14)));
				System.out.println(patient.toString());
				psy.addPatient(patient);
			}
			
			/*Remplir liste Consultation*/
			PreparedStatement pst02 = this.getConnect().prepareStatement(sqlRequete02);

			ResultSet rs02 = pst02.executeQuery();
			consultationDao = new ConsultationDAO(this.getConnect());
			reglement = new ReglementDAO(this.getConnect());
			while(rs02.next()) {
				consultation = new Consultation(rs02.getFloat(1), rs02.getDate(2), rs02.getDate(3), rs02.getDate(4), rs02.getInt(5), rs02.getInt(6), reglement.find(rs02.getInt(7)), getPatient(psy.getListPatients(),rs02.getInt(8)));
				psy.addConsultation(consultation);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() + "\t" + e.getMessage());
		}

		return psy;
	}
	
	private Patient getPatient(List<Patient> list,int id) {
		Patient patient = null;
		for (Patient patients : list) {
			if(patients.getId_Patient() == id) {
				patient = patients;
			}
		}
		return patient;
	}

}
