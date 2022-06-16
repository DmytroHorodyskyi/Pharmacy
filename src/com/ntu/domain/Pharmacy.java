package com.ntu.domain;

public class Pharmacy {
	//поля
		private long idph;
		private String pharmacycol;
		private String address;
		private String phone;
		private String owner;
		
		//конструктор 1
		public Pharmacy() {
			super();
		}
		//конструктор 2
		public Pharmacy(String pharmacycol, String address, String phone, String owner) {
		super();
		this.pharmacycol = pharmacycol;
		this.address = address;
		this.phone = phone;
		this.owner = owner;
		}
		//конструктор 3
		public Pharmacy(long idph, String pharmacycol, String address, String phone, String owner) {
		super();
		this.idph = idph;
		this.pharmacycol = pharmacycol;
		this.address = address;
		this.phone = phone;
		this.owner = owner;
		}
		//геттери та сеттери
		public long getIdph() {
			return idph;
		}
		public void setIdph(long idph) {
			this.idph = idph;
		}
		public String getPharmacycol() {
			return pharmacycol;
		}
		public void setPharmacycol(String pharmacycol) {
			this.pharmacycol = pharmacycol;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		@Override
		public String toString() {
			return"Pharmacy [idph=" + idph + ", pharmacycol=" + pharmacycol + ", address=" + address +
					", phone=" + phone + ", owner=" + owner + "]";
		}
}
