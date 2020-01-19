package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Classification;
import classes.Profession;

public class ProfessionDAO extends DAO<Profession> {

	public ProfessionDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Profession obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Profession obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Profession obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Profession find(int id) {
		/*PreparedStatement*/
		String sqlRequete ="SELECT nom FROM profession WHERE idprofession = ?";
		String result = "";
		/*VAR*/
		Profession profession = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			profession = new Profession(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return profession;
	}

}
