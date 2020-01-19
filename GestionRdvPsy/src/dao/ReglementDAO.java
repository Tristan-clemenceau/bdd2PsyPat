package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Profession;
import classes.Reglement;

public class ReglementDAO extends DAO<Reglement>{

	public ReglementDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Reglement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reglement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reglement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reglement find(int id) {
		/*PreparedStatement*/
		String sqlRequete ="SELECT nom FROM psyUser.reglement WHERE idreglement = ?";
		String result = "";
		/*VAR*/
		Reglement reglement = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			reglement = new Reglement(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return reglement;
	}

}
