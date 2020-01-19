package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {

	private static Connection connection = null;

	public DAOFactory(Connection conn) {
		this.connection = conn;
	}

	public static DAO getClassification() {
		return new ClassificationDAO(connection);
	}

	public static DAO getConsultation() {
		return new ConsultationDAO(connection);
	}

	public static DAO getPatient() {
		return new PatientDAO(connection);
	}

	public static DAO getProfession() {
		return new ProfessionDAO(connection);
	}

	public static DAO getPsy() {
		return new PsyDAO(connection);
	}

	public static DAO getReglement() {
		return new ReglementDAO(connection);
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
