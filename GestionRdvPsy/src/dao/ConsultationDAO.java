package dao;

import java.sql.Connection;
import java.sql.Date;
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
		String sqlRequete ="SELECT idconsultation,dateconsultation,datearrivee,datefin,prix,anxiete,idreglement from consultation where idconsultation = ?";
		/*VAR*/
		ReglementDAO reglement = null;
		Consultation consultation = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				reglement = new ReglementDAO(this.getConnect());
				consultation = new Consultation(rs.getFloat(5), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getInt(6), rs.getInt(1), reglement.find(rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return consultation;
	}

}
