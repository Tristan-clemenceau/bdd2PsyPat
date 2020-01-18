package dao;

import java.sql.Connection;

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
		// TODO Auto-generated method stub
		return null;
	}

}
