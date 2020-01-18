package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Auth extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblAuthentification;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auth frame = new Auth();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		lblUsername.setBounds(65, 133, 148, 14);
		panel_1.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(174, 133, 179, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(65, 219, 87, 14);
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 219, 179, 20);
		panel_1.add(passwordField);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 25, 389, 97);
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
			
		}else {
			disMessage("Erreur","aucun champs n'est remplis");
		}
		Home frame = new Home();
		frame.setVisible(true);	
	}
	
	public boolean isFieldFill() {
		return false;
	}
	
	public void disMessage(String statut,String message) {
		lblNewLabel.setText("["+statut.toUpperCase()+"] "+message);;
	}
}
