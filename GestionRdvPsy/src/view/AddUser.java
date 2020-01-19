package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classes.Classification;
import classes.Patient;

public class AddUser extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtPrenom_1;
	private JTextField txtJour;
	private JTextField txtNumero;
	private JTextField txtNomRue;
	private JTextField txtVille;
	private JTextField txtCodePostal;
	private JTextField txtAdresseMail;
	private JTextField txtConnu;
	private JLabel lbl_Information;
	private JComboBox comboBox;
	private JTextField txtMm;
	private JTextField txtYyyy;
	private Patient patient;

	public AddUser() {
		setBounds(100, 100, 535, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Ajouter utilisateur");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			txtNom = new JTextField();
			txtNom.setText("nom");
			txtNom.setBounds(201, 32, 96, 20);
			panel.add(txtNom);
			txtNom.setColumns(10);
			
			txtPrenom = new JTextField();
			txtPrenom.setText("prenom 1");
			txtPrenom.setColumns(10);
			txtPrenom.setBounds(115, 63, 96, 20);
			panel.add(txtPrenom);
			
			txtPrenom_1 = new JTextField();
			txtPrenom_1.setText("prenom 2");
			txtPrenom_1.setColumns(10);
			txtPrenom_1.setBounds(325, 63, 96, 20);
			panel.add(txtPrenom_1);
			
			txtJour = new JTextField();
			txtJour.setText("D");
			txtJour.setColumns(10);
			txtJour.setBounds(76, 109, 49, 20);
			panel.add(txtJour);
			
			JLabel lblNom = new JLabel("Nom : ");
			lblNom.setBounds(146, 35, 49, 14);
			panel.add(lblNom);
			
			JLabel lblPrenom = new JLabel("Prenom 1 :");
			lblPrenom.setBounds(46, 66, 59, 14);
			panel.add(lblPrenom);
			
			JLabel lblPrenom_1 = new JLabel("Prenom 2 :");
			lblPrenom_1.setBounds(260, 66, 59, 14);
			panel.add(lblPrenom_1);
			
			JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
			lblDateDeNaissance.setBounds(168, 95, 104, 14);
			panel.add(lblDateDeNaissance);
			
			JLabel lblNumeroRue = new JLabel("Numero rue :");
			lblNumeroRue.setBounds(21, 179, 104, 14);
			panel.add(lblNumeroRue);
			
			txtNumero = new JTextField();
			txtNumero.setText("numero");
			txtNumero.setColumns(10);
			txtNumero.setBounds(96, 176, 49, 20);
			panel.add(txtNumero);
			
			JLabel lblNomRue = new JLabel("Nom rue :");
			lblNomRue.setBounds(168, 179, 104, 14);
			panel.add(lblNomRue);
			
			txtNomRue = new JTextField();
			txtNomRue.setText("Nom rue");
			txtNomRue.setColumns(10);
			txtNomRue.setBounds(225, 176, 96, 20);
			panel.add(txtNomRue);
			
			JLabel lblVille = new JLabel("Ville :");
			lblVille.setBounds(337, 179, 104, 14);
			panel.add(lblVille);
			
			txtVille = new JTextField();
			txtVille.setText("Ville");
			txtVille.setColumns(10);
			txtVille.setBounds(394, 176, 96, 20);
			panel.add(txtVille);
			
			JLabel lblCodePostal = new JLabel("Code Postal :");
			lblCodePostal.setBounds(21, 224, 104, 14);
			panel.add(lblCodePostal);
			
			txtCodePostal = new JTextField();
			txtCodePostal.setText("Code postal");
			txtCodePostal.setColumns(10);
			txtCodePostal.setBounds(96, 221, 96, 20);
			panel.add(txtCodePostal);
			
			JLabel lblMail = new JLabel("Adresse mail :");
			lblMail.setBounds(21, 272, 104, 14);
			panel.add(lblMail);
			
			txtAdresseMail = new JTextField();
			txtAdresseMail.setText("Adresse Mail");
			txtAdresseMail.setColumns(10);
			txtAdresseMail.setBounds(96, 269, 96, 20);
			panel.add(txtAdresseMail);
			
			JLabel lblConnu = new JLabel("Connu :");
			lblConnu.setBounds(251, 269, 104, 14);
			panel.add(lblConnu);
			
			txtConnu = new JTextField();
			txtConnu.setText("Connu");
			txtConnu.setColumns(10);
			txtConnu.setBounds(326, 266, 96, 20);
			panel.add(txtConnu);
			
			lbl_Information = new JLabel();
			lbl_Information.setBounds(56, 353, 434, 14);
			panel.add(lbl_Information);
			
			JLabel lblNewLabel_1 = new JLabel("Classification :");
			lblNewLabel_1.setBounds(159, 314, 84, 14);
			panel.add(lblNewLabel_1);
			
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enfant", "Ado", "Homme", "Femme", "Couple"}));
			comboBox.setBounds(253, 310, 102, 22);
			panel.add(comboBox);
			
			JLabel lblJour = new JLabel("Jour :");
			lblJour.setBounds(35, 112, 59, 14);
			panel.add(lblJour);
			
			JLabel lblMois = new JLabel("Mois :");
			lblMois.setBounds(153, 112, 59, 14);
			panel.add(lblMois);
			
			txtMm = new JTextField();
			txtMm.setText("MM");
			txtMm.setColumns(10);
			txtMm.setBounds(194, 109, 49, 20);
			panel.add(txtMm);
			
			JLabel lblAnnee = new JLabel("Annee :");
			lblAnnee.setBounds(291, 112, 59, 14);
			panel.add(lblAnnee);
			
			txtYyyy = new JTextField();
			txtYyyy.setText("YYYY");
			txtYyyy.setColumns(10);
			txtYyyy.setBounds(332, 109, 49, 20);
			panel.add(txtYyyy);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand().toLowerCase()) {
		case "OK":
			/*Verifier les champs*/
			break;
		case "Cancel":
			break;
		default :
			break;
			}
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Patient getResult() {
		Patient patient = null;
		Classification classification = new Classification((String)comboBox.getSelectedItem());
		int year = Integer.parseInt(txtYyyy.getText());
		int month = Integer.parseInt(txtYyyy.getText());
		int day = Integer.parseInt(txtYyyy.getText());
		
		Date dateNaissance = new Date(year, month, day);
		patient = new Patient(txtNom.getText(), txtPrenom.getText(), txtPrenom_1.getText(), txtNomRue.getText(), txtNumero.getText(), txtCodePostal.getText(), txtVille.getText(), txtAdresseMail.getText(), txtConnu.getText(), null, dateNaissance, classification);
		return patient;
	}
}
