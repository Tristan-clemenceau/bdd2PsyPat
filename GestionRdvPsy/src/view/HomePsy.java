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

import javax.swing.JButton;
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


public class HomePsy extends JFrame implements ActionListener {
	/*Autre*/
	private CardLayout cardLayout;
	private JSplitPane splitPane;
	private String user,pass;
	/*Pannel*/
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel pnl_Schedule;
	private JScrollPane scrollPane;
	private JPanel pnl_Patients;
	private JPanel panel_5;
	private JPanel panel_2;
	/*Button*/
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnProfile;
	private JButton btnAdd;
	private JLabel lblPatients;
	private JTable table_1;
	/*DAO*/
	DAOFactory factory = new DAOFactory(null);
	private JTable table;

	/**
	 * Create the frame.
	 */
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
		
		panel_2 = new JPanel();
		pnl_Patients.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		/*Metode set title*/
		/*Methode set data*/
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"trez", "yo"},
			},
			new String[] {
				"uuu", "yyyy","uuu", "yyyy","uuu", "yyyy","uuu", "yyyy","uuu", "yyyy","uuu", "yyyy"
			}
		));
		panel_2.add(table.getTableHeader(),BorderLayout.NORTH);
		panel_2.add(table,BorderLayout.CENTER);

		pnl_Schedule = new JPanel();
		pnl_Schedule.setBackground(Color.GREEN);
		panel_1.add(pnl_Schedule, "pnl_Schedule");

		scrollPane = new JScrollPane();
		pnl_Schedule.add(scrollPane);

		table_1 = new JTable();
		pnl_Schedule.add(table_1);

		panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		panel_1.add(panel_5, "panel_5");
		
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
			cardLayout.show(panel_1, "panel_5");
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
			System.out.println("ok");
			factory.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState() +"\t"+e.getMessage());
		}
		
		this.factory = new DAOFactory(null);
	}
	
	private String[] setTitle() {
		return null;
	}
	
	private Object[][] setData(){
		return null;
	}
}
