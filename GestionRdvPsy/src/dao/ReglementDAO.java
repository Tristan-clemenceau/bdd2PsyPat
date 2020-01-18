package dao;

import java.sql.Connection;

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
		// TODO Auto-generated method stub
		return null;
	}

}
