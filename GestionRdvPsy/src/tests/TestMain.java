package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import view.Auth;

public class TestMain {

	public static void main(String[] args) {
		Auth auth = new Auth();
		auth.setVisible(true);
	}

}
