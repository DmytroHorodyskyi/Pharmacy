package com.ntu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ntu.dao.PharmacyDAOImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Phd extends JFrame {

	private JTextField txtId;
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;


	/**
	 * Create the frame.
	 */
	public Phd() {
		setTitle("Removal\r\n pharmacy");
		setBounds(100, 100, 910, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the idph of the record being deleted:");
		lblNewLabel.setBounds(35, 11, 324, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtId.setBounds(150, 90, 100, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = txtId.getText();
				int idph =Integer.parseInt(i);
				PharmacyDAOImpl pharmacy=new PharmacyDAOImpl();
				pharmacy.deletePharmacy(idph);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(100, 170, 100, 30);
		contentPane.add(btnNewButton);
		
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
					String query ="select * from Pharmacy";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.setRowCount(0);
					
					int cols = rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String idph, pharmacycol, address, phone, owner;
					while(rs.next()) {
						idph=rs.getString(1);
						pharmacycol=rs.getString(2);
						address=rs.getString(3);
						phone=rs.getString(4);
						owner=rs.getString(5);
						String[] row = {idph, pharmacycol, address, phone, owner};
						model.addRow(row);
					}

					
					
				}catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(200, 170, 100, 30);
		contentPane.add(btnNewButton_1);
	}
}