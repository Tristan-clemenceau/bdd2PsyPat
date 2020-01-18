package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Auth extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblAuthentification;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;
	private Connection conn = null;
	private HomePatient home;

	public Auth() {
		setResizable(false);
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblAuthentification = new JLabel("Authentification");
		lblAuthentification.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblAuthentification);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(174, 309, 87, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(65, 125, 148, 31);
		panel_1.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(174, 133, 179, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(65, 216, 87, 20);
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 219, 179, 20);
		panel_1.add(passwordField);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(12, 25, 389, 97);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblClemenceauTristan = new JLabel("Tristan & Jordan");
		panel_2.add(lblClemenceauTristan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isFieldFill()) {
			if(testConnexion(textField.getText(),passwordField.getText())) {
				this.conn = setConnection(textField.getText(),passwordField.getText());
				home = new HomePatient(this.conn);
				home.setVisible(true);
			}
		}else {
			disMessage("Erreur","Les champs doivent être Remplis");
		}
	}
	
	private boolean isFieldFill() {
		boolean login = !(textField.getText().equals(""));
		boolean pass = !(passwordField.getText().equals(""));
		return (login&&pass);
	}
	
	private void disMessage(String statut,String message) {
		lblNewLabel.setText("["+statut.toUpperCase()+"] "+message);;
	}
	
	private boolean testConnexion(String username,String password) {
		System.out.println("TestConnection");
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", username, password)) {
			if (conn != null) {
				disMessage("Success","Connected to the database!");
				conn.close();
				return true;
			} else {
				disMessage("erreur","Failed to make connection!");
				return false;
			}
		} catch (SQLException e) {
			disMessage("erreur",e.getMessage());
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	private Connection setConnection(String username,String password) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", username, password)) {
			if (conn != null) {
				disMessage("Success","Connected to the database!");
				return conn;
			} else {
				disMessage("erreur","Failed to make connection!");
				return null;
			}
		} catch (SQLException e) {
			disMessage("erreur",e.getMessage());
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public Connection getConn() {
		return conn;
	}
	
}
