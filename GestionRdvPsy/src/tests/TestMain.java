package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import classes.Patient;
import classes.Psy;
import dao.DAO;
import dao.DAOFactory;
import view.Auth;

public class TestMain {

	public static void main(String[] args) {
		test02();
	}

	public static void test01() {
		Auth auth = new Auth();
		auth.setVisible(true);
	}

	public static void test02() {/*PSY*/
		DAOFactory daoFac = new DAOFactory(setCon("psyUser","admin"));
		DAO<Psy> psy = daoFac.getPsyDao();
		
		
	}
	
	public static void test03() {/*PSY*/
		DAOFactory daoFac = new DAOFactory(setCon("patientUser","rootttt"));
		DAO<Patient> patient = daoFac.getPatient();
	}

	private static Connection setCon(String username, String password) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",username, password)) {
			if (conn != null) {
				System.out.println("Connecté à la base de donnée");
				return conn;
			} else {
				System.out.println("Impossible de joindre la base de donnée");
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
