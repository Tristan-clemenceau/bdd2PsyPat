package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Consultation;
import classes.Patient;
import classes.Profession;
import classes.Reglement;

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
		/*PreparedStatement*/
		String sqlRequete ="SELECT * from psyUser.patient where idpatient = ?";
		String sqlRequete02 ="SELECT p.nom,ph.dateprofessionhistorique,ph.idprofession FROM psyUser.professionhistorique ph,psyUser.profession p WHERE ph.idprofession = p.idprofession AND ph.idpatient = ?";
		String sqlRequete03 ="SELECT c.prix,c.dateconsultation,c.datearrivee,c.datefin,c.anxiete,c.idconsultation,p.idpatient FROM psyUser.consultation c , psyUser.patient p WHERE c.idconsultation = p.idconsultation AND p.idpatient = ?";
		/*VAR*/
		ClassificationDAO classification = null;
		ProfessionDAO professionDao = null;
		ConsultationDAO consultationDAO = null;
		ReglementDAO reglementDAO = null;
		Profession profession=null;
		Patient patient = null;
		Consultation consultation = null;
		Reglement reglement = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				classification = new ClassificationDAO(this.getConnect());
				patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getDate(5), classification.find(rs.getInt(14)));
			}
			
			/*Remplir liste Profession*/
			PreparedStatement pst02 = this.getConnect().prepareStatement(sqlRequete02);
			pst02.setInt(1, patient.getId_Patient());
			
			ResultSet rs02=pst02.executeQuery();
			professionDao = new ProfessionDAO(this.getConnect());
			while(rs02.next()) {
				profession = new Profession(rs02.getString(1), rs02.getDate(2), rs02.getInt(3));
				patient.addProfession(profession);
			}
			
			/*Remplir liste Consultation*/
			PreparedStatement pst03 = this.getConnect().prepareStatement(sqlRequete03);
			pst03.setInt(1, patient.getId_Patient());
			
			ResultSet rs03=pst03.executeQuery();
			consultationDAO = new ConsultationDAO(this.getConnect());
			while(rs03.next()) {
				reglementDAO = new ReglementDAO(this.getConnect());
				consultation = new Consultation(rs03.getFloat(1), rs03.getDate(2), rs03.getDate(3), rs03.getDate(4), rs03.getInt(5), rs03.getInt(6), reglementDAO.find(id));
				patient.addConsultation(consultation);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return patient;
	}

}
