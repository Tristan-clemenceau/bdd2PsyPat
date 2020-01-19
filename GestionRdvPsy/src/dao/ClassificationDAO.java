package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Classification;

public class ClassificationDAO extends DAO<Classification>{

	public ClassificationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Classification obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Classification obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Classification obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Classification find(int id) {
		/*PreparedStatement*/
		String sqlRequete ="SELECT nom FROM classification WHERE idclassification = ?";
		String result = "";
		/*VAR*/
		Classification classification = null;
		try {
			PreparedStatement pst = this.getConnect().prepareStatement(sqlRequete);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			classification = new Classification(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		return classification;
	}

}
