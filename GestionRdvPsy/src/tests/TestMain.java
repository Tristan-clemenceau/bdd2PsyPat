package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Classification;
import classes.Patient;
import classes.Profession;
import classes.Psy;
import dao.DAO;
import dao.DAOFactory;
import dao.ProfessionDAO;
import view.Auth;

public class TestMain {

	public static void main(String[] args) {
		test04();
	}

	public static void test01() {
		Auth auth = new Auth();
		auth.setVisible(true);
	}

	/*public static void test02() {//PSY
		DAOFactory daoFac = new DAOFactory(setCon("psyUser","admin"));
		DAO<Psy> psy = daoFac.getPsyDao();
	}*/
	
	/*public static void test03() {//PATIENT
		DAOFactory daoFac = new DAOFactory(setCon("patientUser","rootttt"));
		DAO<Patient> patient = daoFac.getPatient();
	}*/
	
	public static void test04() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","psyUser", "admin");
			DAOFactory daoFac = new DAOFactory(conn);
			DAO<Profession> prof = daoFac.getProfession();
			DAO<Classification> clas = daoFac.getClassification();
			Profession test01 = prof.find(1);
			Classification class01 = clas.find(1);
			test01 = prof.find(2);
			test01 = prof.find(3);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
	}

}
