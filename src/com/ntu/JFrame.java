package com.ntu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;

public class JFrame extends javax.swing.JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
public int a;
public JFrame() {

		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle("Pharmacy");
		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose a table:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(28, 140, 142, 23);
		getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pharmacy");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(38, 210, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=1;
		}});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Preparation");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_1.setBounds(38, 290, 131, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=2;
		}});
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Manufacturer");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_2.setBounds(38, 370, 142, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=3;
		}});
		
		JLabel lblNewLabel_1 = new JLabel("Choose an action:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(200, 140, 177, 23);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a==1) {
				Ph ph=new Ph();
				ph.setVisible(true);
				}
				else if(a==2) {
					Pr pr=new Pr();
					pr.setVisible(true);
					}
				else if(a==3) {
					M m=new M();
					m.setVisible(true);
					}
			}
		});
		buttonGroup.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(210, 210, 130, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a==1) {
				Phd phd=new Phd();
				phd.setVisible(true);
				}
				else if(a==2) {
					Prd prd=new Prd();
					prd.setVisible(true);
					}
				else if(a==3) {
					Md md=new Md();
					md.setVisible(true);
					
			}
		}});
		buttonGroup.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(210, 290, 130, 30);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a==1) {
					Phu phu=new Phu();
					phu.setVisible(true);
					}
					else if(a==2) {
						Pru pru=new Pru();
						pru.setVisible(true);
						}
					else if(a==3) {
						Mu mu=new Mu();
						mu.setVisible(true);
						
				}
			}
		});
		buttonGroup.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(210, 370, 130, 30);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Pharmacy network management center");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(223, 15, 496, 47);
		getContentPane().add(lblNewLabel_2);
		
		 JLabel jl3=new JLabel(new ImageIcon("A.jpg"));
		 getContentPane().add(jl3);
	        jl3.setBounds(394, 109, 480, 322);

	}
}
