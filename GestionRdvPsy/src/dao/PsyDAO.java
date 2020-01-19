package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Consultation;
import classes.Patient;
import classes.Profession;
import classes.Psy;

public class PsyDAO extends DAO<Psy>{

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
		return null;
	}
	
	public Psy setEnv() {
		Psy psy = new Psy();
		
		/*PreparedStatement*/
		String sqlRequete ="SELECT nom FROM profession WHERE idprofession = ?";
		String result = "";
		/*VAR*/
		Consultation consultation = null;
		Patient patient = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			//pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			//profession = new Profession(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		
		
		psy.addConsultation(consultation);
		psy.addPatient(patient);
		
		return psy;
	}

}
