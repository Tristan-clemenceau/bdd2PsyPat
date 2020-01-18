package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.DAOFactory;
import view.Auth;

public class TestMain {

	public static void main(String[] args) {
		test01();
	}
	
	public static void test01() {
		Auth auth = new Auth();
		auth.setVisible(true);
	}
	
	public static void test02() {
		
		DAOFactory dao = new DAOFactory(setCon("psyUser","admin"));
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
