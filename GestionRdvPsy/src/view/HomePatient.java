package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Consultation;
import classes.Patient;
import dao.DAO;
import dao.DAOFactory;

public class HomePatient extends JFrame implements ActionListener {
	/* Autre */
	private CardLayout cardLayout;
	private JSplitPane splitPane;
	private String user, pass;
	private JTable table;
	private JLabel lblNewLabel;
	/* Pannel */
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel pnl_Profile;
	private JPanel pnl_Schedule;
	private JPanel panel_2;
	/* Button */
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnProfile;
	/* Label */
	private JLabel lblProfile;
	private JLabel lblPrenom;
	private JLabel lblNom_1;
	private JLabel lblEmail;
	private JLabel lblPassword;
	/* Textfield */
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/* DAO */
	DAOFactory factory = new DAOFactory(null);
	Patient patient = null;
	
	
	

	public HomePatient(String user, String pass) {
		this.user = user;
		this.pass = pass;

		/* Setting factory */
		setFactory();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setPreferredSize(new Dimension(229, 25));
		contentPane.add(splitPane, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		panel.setBackground(SystemColor.controlDkShadow);
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("Schedule");
		btnNewButton.setBounds(50, 194, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);

		btnNewButton_1 = new JButton("Log out");/* A delete */
		btnNewButton_1.setBounds(50, 243, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);

		btnProfile = new JButton("Profile");
		btnProfile.setBounds(50, 144, 89, 23);
		panel.add(btnProfile);
		btnProfile.addActionListener(this);

		panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout) (panel_1.getLayout());

		pnl_Profile = new JPanel();
		pnl_Profile.setBackground(Color.RED);
		panel_1.add(pnl_Profile, "pnl_Profile");
		pnl_Profile.setLayout(null);

		lblProfile = new JLabel("Profile");
		lblProfile.setBounds(0, 0, 740, 25);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnl_Profile.add(lblProfile);

		lblPrenom = new JLabel("Prenom(s) :");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrenom.setBounds(33, 140, 109, 14);
		pnl_Profile.add(lblPrenom);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(152, 140, 146, 20);
		pnl_Profile.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(331, 140, 161, 20);
		pnl_Profile.add(textField_1);

		lblNom_1 = new JLabel("Nom :");
		lblNom_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNom_1.setBounds(33, 199, 79, 14);
		pnl_Profile.add(lblNom_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(115, 196, 96, 20);
		pnl_Profile.add(textField_2);

		lblEmail = new JLabel("Login : ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(33, 250, 109, 35);
		pnl_Profile.add(lblEmail);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(152, 260, 206, 20);
		pnl_Profile.add(textField_3);

		lblPassword = new JLabel("Email :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(33, 314, 101, 14);
		pnl_Profile.add(lblPassword);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(163, 314, 96, 20);
		pnl_Profile.add(textField_4);

		pnl_Schedule = new JPanel();
		pnl_Schedule.setBackground(Color.GREEN);
		panel_1.add(pnl_Schedule, "pnl_Schedule");
		pnl_Schedule.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Schedule");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnl_Schedule.add(lblNewLabel, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		pnl_Schedule.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		setProfileView();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(setData(),setTitle()));
		panel_2.add(table.getTableHeader(),BorderLayout.NORTH);
		panel_2.add(table, BorderLayout.CENTER);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().toLowerCase()) {
		case "profile":
			cardLayout.show(panel_1, "pnl_Profile");
			break;
		case "schedule":
			cardLayout.show(panel_1, "pnl_Schedule");
			break;
		case "log out":
			factory.closeConnection();
			this.dispose();
			break;
		default:
			break;
		}

	}

	public void setFactory() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", this.user, this.pass);
			factory = new DAOFactory(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() + "\t" + e.getMessage());
		}
	}

	private void setProfileView() {
		DAO<Patient> patientDao = factory.getPatient();
		patient = patientDao.find(getInt());

		textField.setText(patient.getPremierPrenom());
		textField_1.setText(patient.getDeuxiemePrenom());
		textField_2.setText(patient.getNom());
		textField_3.setText(user);
		textField_4.setText(patient.getMail());

	}

	private int getInt() {
		/* PreparedStatement */
		String sqlRequete = "Select idpatient from psyUser.loginpatient where login = ?";
		int idPatient = 0;
		/* VAR */
		try {
			PreparedStatement pst = factory.getConnection().prepareStatement(sqlRequete);
			pst.setString(1, user);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				idPatient = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() + "\t" + e.getMessage());
		}
		return idPatient;
	}
	
	private String[] setTitle() {
		String[] titre = {"Date Consultation","Prix ","Reglement"};
		return titre;
	}
	
	private Object[][] setData(){
		
		Object[][] data = new Object[patient.getListConsutations().size()][3];
		
		for (int cpt = 0;cpt<patient.getListConsutations().size();cpt++) {
			Consultation consultation = patient.getListConsutations().get(cpt);
			data[cpt][0]= consultation.getDate().toLocaleString();
			data[cpt][1]= consultation.getPrix();
			data[cpt][2]= consultation.getReglement().getReglement();
		}
		return data;
	}
}