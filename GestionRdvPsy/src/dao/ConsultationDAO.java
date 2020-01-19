package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Consultation;
import classes.Reglement;

public class ConsultationDAO extends DAO<Consultation> {

	public ConsultationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Consultation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Consultation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Consultation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Consultation find(int id) {
		/*PreparedStatement*/
		String sqlRequete ="SELECT nom FROM reglement WHERE idreglement = ?";
		String result = "";
		/*VAR*/
		Consultation consultation = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			
			//consultation = new Consultation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return consultation;
	}

}
