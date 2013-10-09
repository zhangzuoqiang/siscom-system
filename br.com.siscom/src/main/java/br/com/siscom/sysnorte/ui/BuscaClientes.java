package br.com.siscom.sysnorte.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class BuscaClientes extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscaClientes dialog = new BuscaClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscaClientes() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busca de Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Razão Social/Nome:");
		lblNewLabel.setBounds(10, 21, 95, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(115, 18, 716, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox cb_type_document = new JComboBox();
		cb_type_document.setModel(new DefaultComboBoxModel(new String[] {" -", "CNPJ", "CPF"}));
		cb_type_document.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_type_document.setBounds(10, 46, 95, 20);
		panel.add(cb_type_document);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(115, 47, 716, 20);
		panel.add(textField_1);
	}
}
