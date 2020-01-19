package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Classification;
import classes.Consultation;
import classes.Patient;
import classes.Profession;
import classes.Psy;
import dao.DAO;
import dao.DAOFactory;
import dao.PsyDAO;


public class HomePsy extends JFrame implements ActionListener {
	/*Autre*/
	private CardLayout cardLayout;
	private JSplitPane splitPane;
	private String user,pass;
	private JTable table;
	private JTable table_1;
	/*Pannel*/
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel pnl_Schedule;
	private JPanel pnl_Patients;
	private JPanel panel_2;
	private JPanel panel_3;
	
	/*Button*/
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnProfile;
	private JButton btnAdd;
	private JLabel lblPatients;
	private JLabel lblNewLabel;
	/*DAO*/
	DAOFactory factory = new DAOFactory(null);
	
	public HomePsy(String user,String pass) {
		this.user = user;
		this.pass = pass;
		
		/*Setting factory*/
		setFactory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setPreferredSize(new Dimension(229, 25));
		contentPane.add(splitPane, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setMinimumSize(new Dimension(200, 10));
		panel.setPreferredSize(new Dimension(210, 10));
		panel.setBackground(SystemColor.controlDkShadow);
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("Schedule");/*2 Schedule*/
		btnNewButton.setBounds(50, 194, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);

		btnNewButton_1 = new JButton("Log out");/*3 Log out*/
		btnNewButton_1.setBounds(50, 243, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);

		btnProfile = new JButton("Patients");/* 1 Patients*/
		btnProfile.setBounds(50, 144, 89, 23);
		panel.add(btnProfile);
		btnProfile.addActionListener(this);

		panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout) (panel_1.getLayout());

		pnl_Patients = new JPanel();
		pnl_Patients.setBackground(Color.MAGENTA);
		panel_1.add(pnl_Patients, "pnl_Patients");
		pnl_Patients.setLayout(new BorderLayout(0, 0));

		lblPatients = new JLabel("Patients");
		lblPatients.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnl_Patients.add(lblPatients, BorderLayout.NORTH);

		btnAdd = new JButton("Add");
		pnl_Patients.add(btnAdd, BorderLayout.SOUTH);
		btnAdd.addActionListener(this);
		
		panel_2 = new JPanel();
		pnl_Patients.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(setData(),setTitle()));
		panel_2.add(table.getTableHeader(),BorderLayout.NORTH);
		panel_2.add(table,BorderLayout.CENTER);

		pnl_Schedule = new JPanel();
		pnl_Schedule.setBackground(Color.GREEN);
		panel_1.add(pnl_Schedule, "pnl_Schedule");
		pnl_Schedule.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_Schedule.add(lblNewLabel, BorderLayout.NORTH);
		
		panel_3 = new JPanel();
		pnl_Schedule.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(setData2(),setTitle2()));
		panel_3.add(table_1.getTableHeader(),BorderLayout.NORTH);
		panel_3.add(table_1,BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().toLowerCase()) {
		case "schedule":
			cardLayout.show(panel_1, "pnl_Schedule");
			break;
		case "patients":
			cardLayout.show(panel_1, "pnl_Patients");
			break;
		case "log out":
			factory.closeConnection();
			this.dispose();
			break;
		case "add" :
			AddUser dialog = new AddUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.show(true);
			break;
		default:
			break;
		}

	}
	
	public void setFactory() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",this.user, this.pass);
			factory = new DAOFactory(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
	}
	
	private String[] setTitle() {
		String[] titre = {"Nom","PremierPrenom","DeuxiemePrenom","Date de naissance","Nom rue","Num rue","Code postal","Ville","Mail","Connu","Remarque"};
		return titre;
	}
	
	private String[] setTitle2() {
		String[] titre = {"Date Consultation","Date Arrivee","Date Fin","Prix ","Anxiete","Reglement"};
		return titre;
	}
	
	private Object[][] setData(){
		DAO<Psy> psyDAO = factory.getPsy();
		Psy psy = psyDAO.find(0);
		
		Object[][] data = new Object[psy.getListPatients().size()][11];
		
		for (int cpt = 0;cpt<psy.getListPatients().size();cpt++) {
			Patient patient = psy.getListPatients().get(cpt);
			data[cpt][0]= patient.getNom();
			data[cpt][1]= patient.getPremierPrenom();
			data[cpt][2]= patient.getDeuxiemePrenom();
			data[cpt][3]= patient.getDateDeNaissance().toLocaleString();
			data[cpt][4]= patient.getNomRue();
			data[cpt][5]= patient.getNumeroRue();
			data[cpt][6]= patient.getCodePostal();
			data[cpt][7]= patient.getVille();
			data[cpt][8]= patient.getMail();
			data[cpt][9]= patient.getConnu();
			data[cpt][10]= patient.getRemarque();
		}
		return data;
	}
	
	private Object[][] setData2(){
		DAO<Psy> psyDAO = factory.getPsy();
		Psy psy = psyDAO.find(0);
		
		Object[][] data = new Object[psy.getListConsultations().size()][6];
		
		for (int cpt = 0;cpt<psy.getListConsultations().size();cpt++) {
			Consultation consultation = psy.getListConsultations().get(cpt);
			data[cpt][0]= consultation.getDate().toLocaleString();
			data[cpt][1]= consultation.getDateArrivee();
			data[cpt][2]= consultation.getDateFin().toLocaleString();
			data[cpt][3]= consultation.getPrix();
			data[cpt][4]= consultation.getAnxiete();
			data[cpt][5]= consultation.getReglement().getReglement();
		}
		return data;
	}
}
