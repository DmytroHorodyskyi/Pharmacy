package com.ntu.domain;

import java.io.Serializable;

public class Preparations implements Serializable {
		private static final long serialVersionUID = 1L;
	//поля
			private long idpr;
			private String preparationscol;// назвакниги
			private String price;// ріквидання
			private String quantity;
			private Pharmacy pharmacy;// назвакниги
			private Manufacturer manufacturer;// назвакниги
			//конструктор 1
			public Preparations() {
				super();
			}
			//конструктор 2
			public Preparations(String preparationscol, String price, String quantity, Pharmacy pharmacy, Manufacturer manufacturer) {
			super();
			this.preparationscol = preparationscol;
			this.price = price;
			this.quantity = quantity;
			this.pharmacy = pharmacy;
			this.manufacturer = manufacturer;
			}
			//конструктор 3
			public Preparations(long idpr, String preparationscol, String price, String quantity, Pharmacy pharmacy, Manufacturer manufacturer) {
			super();
			this.idpr = idpr;
			this.preparationscol = preparationscol;
			this.price = price;
			this.quantity = quantity;
			this.pharmacy = pharmacy;
			this.manufacturer = manufacturer;
			}
			//геттери та сеттери
			public long getIdpr() {
				return idpr;
			}
			public void setIdpr(long idpr) {
				this.idpr = idpr;
			}
			public String getPreparationscol() {
				return preparationscol;
			}
			public void setPreparationscol(String preparationscol) {
				this.preparationscol = preparationscol;
			}
			public String getPrice() {
				return price;
			}
			public void setPrice(String price) {
				this.price = price;
			}
			public String getQuantity() {
				return quantity;
			}
			public void setQuantity(String quantity) {
				this.quantity = quantity;
			}
			public Pharmacy getPharmacy() {
				return pharmacy;
			}
			public void setPharmacy(Pharmacy pharmacy) {
				this.pharmacy = pharmacy;
			}
			public Manufacturer getManufacturer() {
				return manufacturer;
			}
			public void setManufacturer(Manufacturer manufacturer) {
				this.manufacturer = manufacturer;
			}
			@Override
			public String toString() {
				return"Preparation [idpr=" + idpr + ", preparationscol=" + preparationscol + ", price=" + price +", quantity=" + quantity
						+ ", pharmacy=" + pharmacy.getIdph()  + " - " + pharmacy.getPharmacycol()+ " - " + pharmacy.getAddress()+ " - " + pharmacy.getPhone()+ " - " + pharmacy.getOwner()   
						+", manufacturer=" + manufacturer.getIdm() + " - " + manufacturer.getManufacturercol() + " - " + manufacturer.getPhone() + " - " + manufacturer.getEmail()+"]";
			}

}
