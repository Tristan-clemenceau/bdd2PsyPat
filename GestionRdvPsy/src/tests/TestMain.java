package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Classification;
import classes.Consultation;
import classes.Patient;
import classes.Profession;
import classes.Psy;
import dao.DAO;
import dao.DAOFactory;
import dao.ProfessionDAO;
import view.Auth;

public class TestMain {

	public static void main(String[] args) {
		test01();
	}

	public static void test01() {
		Auth auth = new Auth();
		auth.setVisible(true);
	}
	
	public static void test04() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","psyUser", "admin");
			DAOFactory daoFac = new DAOFactory(conn);
			
			DAO<Profession> prof = daoFac.getProfession();
			DAO<Classification> clas = daoFac.getClassification();
			DAO<Consultation> consul = daoFac.getConsultation();
			DAO<Patient> patient = daoFac.getPatient();
			DAO<Psy> psy = daoFac.getPsy();

			
			Profession test01 = prof.find(1);
			Classification class01 = clas.find(1);
			Consultation consultation = consul.find(1);
			Patient patient01 = patient.find(1);
			Psy psy01 = psy.find(0);
			
			test01 = prof.find(2);
			test01 = prof.find(3);
			
			System.out.println(class01.toString());
			System.out.println(test01.toString());
			System.out.println(consultation.toString());
			System.out.println(patient01.toString());
			
			psy01.dispPatient();
			psy01.dispConsultation();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
	}

}
