package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAOFactory;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class HomePatient extends JFrame implements ActionListener{
	/*Autre*/
	private CardLayout cardLayout;
	private JSplitPane splitPane;
	/*Pannel*/
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel pnl_Profile;
	private JPanel pnl_Schedule;
	private JScrollPane scrollPane;
	private JPanel panel_5;
	/*Button*/
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnProfile;
	/*Label*/
	private JLabel lblProfile;
	private JLabel lblPrenom;
	private JLabel lblNom_1;
	private JLabel lblEmail;
	private JLabel lblPassword;
	/*Textfield*/
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;
	/*DAO*/
	DAOFactory factory = new DAOFactory(null);

	/**
	 * Create the frame.
	 */
	public HomePatient() {
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

		btnNewButton_1 = new JButton("Log out");/*A delete*/
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

		lblEmail = new JLabel("Email/Login : ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(33, 250, 109, 35);
		pnl_Profile.add(lblEmail);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(152, 260, 206, 20);
		pnl_Profile.add(textField_3);

		lblPassword = new JLabel("Password :");
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
		case "profile":
			cardLayout.show(panel_1, "pnl_Profile");
			break;
		case "schedule":
			cardLayout.show(panel_1, "pnl_Schedule");
			break;
		case "log out":
			cardLayout.show(panel_1, "panel_5");
			break;
		default:
			break;
		}

	}
}