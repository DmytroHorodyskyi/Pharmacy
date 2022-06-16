package com.ntu.domain;

public class Manufacturer {
	//поля
	private long idm;
	private String manufacturercol;
	private String phone;
	private String email;
	
	//конструктор 1
	public Manufacturer() {
		super();
	}
	//конструктор 2
	public Manufacturer(String manufacturercol, String phone, String email) {
	super();
	this.manufacturercol = manufacturercol;
	this.phone = phone;
	this.email = email;
	}
	//конструктор 3
	public Manufacturer(long idm, String manufacturercol, String phone, String email) {
	super();
	this.idm = idm;
	this.manufacturercol = manufacturercol;
	this.phone = phone;
	this.email = email;
	}
	//геттери та сеттери
	public long getIdm() {
		return idm;
	}
	public void setIdm(long idm) {
		this.idm = idm;
	}
	public String getManufacturercol() {
		return manufacturercol;
	}
	public void setManufacturercol(String manufacturercol) {
		this.manufacturercol = manufacturercol;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return"Manufacturer [idm=" + idm + ", manufacturercol=" + manufacturercol + 
				", phone=" + phone + ", email=" + email + "]";
	}
}
