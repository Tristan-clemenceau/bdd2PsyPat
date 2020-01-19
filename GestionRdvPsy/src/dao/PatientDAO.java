package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Consultation;
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
		/*PreparedStatement*/
		String sqlRequete ="SELECT * from patient where idpatient = ?";
		/*VAR*/
		ClassificationDAO classification = null;
		Patient patient = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				classification = new ClassificationDAO(this.getConnect());
				patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getDate(5), classification.find(rs.getInt(14)));
			}
			/*Remplir liste Profession*/
			/*Remplir liste Consultation*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return patient;
	}

}
