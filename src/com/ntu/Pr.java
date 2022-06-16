package com.ntu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ntu.dao.ManufacturerDAO;
import com.ntu.dao.ManufacturerDAOImpl;
import com.ntu.dao.PharmacyDAO;
import com.ntu.dao.PharmacyDAOImpl;
import com.ntu.dao.PreparationsDAO;
import com.ntu.dao.PreparationsDAOImpl;
import com.ntu.domain.Manufacturer;
import com.ntu.domain.Pharmacy;
import com.ntu.domain.Preparations;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Pr extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_5;


	/**
	 * Create the frame.
	 */
	public Pr() {
		setTitle("Addition preparation");
		setBounds(100, 100, 910, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Idpr");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(35, 40, 122, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preparationcol");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(35, 80, 122, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(35, 120, 122, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(35, 160, 122, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Idph");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(35, 200, 122, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Idm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(35, 240, 122, 29);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PharmacyDAO pharmacyDAO =  new PharmacyDAOImpl();
				ManufacturerDAO manufacturerDAO =  new ManufacturerDAOImpl();
				PreparationsDAO preparationsDAO =  new PreparationsDAOImpl();
				String a = textField.getText();
				long idpr =Integer.parseInt(a);
				String Preparationscol=textField_1.getText();
				String Price = textField.getText();
				String Quantity = textField.getText();
				String d = textField.getText();
				
	

				long Idph =Integer.parseInt(d);
				Pharmacy p = pharmacyDAO.getPharmacyById(Idph);
				
				String f = textField.getText();
				
				long Idm =Integer.parseInt(f);
				Manufacturer m = manufacturerDAO.getManufacturerById(Idm);
				
				Preparations preparations=new Preparations(idpr, Preparationscol,Price,Quantity,p,m); 
				//PreparationsDAOImpl preparationsdaoimpl=new PreparationsDAOImpl();
				preparationsDAO.insertPreparations(preparations);	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(200, 280, 91, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(200, 40, 182, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(200, 80, 182, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(200, 120, 182, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(200, 160, 182, 29);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(200, 200, 182, 29);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBounds(200, 240, 182, 29);
		contentPane.add(textField_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(430, 30, 440, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectionFactory c = new ConnectionFactory();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = c.getConnection();
					Statement st=con.createStatement();
					String query ="select * from Preparation";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.setRowCount(0);
					
					int cols = rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String idpr, preparationcol, price, quality, idph, idm;
					while(rs.next()) {
						idpr=rs.getString(1);
						preparationcol=rs.getString(2);
						price=rs.getString(3);
						quality=rs.getString(4);
						idph=rs.getString(5);
						idm=rs.getString(6);
						String[] row = {idpr, preparationcol, price, quality, idph, idm};
						model.addRow(row);
					}

					
					
				}catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(291, 280, 91, 29);
		contentPane.add(btnNewButton_1);
	}
}
