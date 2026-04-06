package com.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	
	@Id
	@Column(name="productId")
	private int pid;
	@Column(name="productName")
	private String pname;
	@Column(name="productPrice")
	private double pprice;
	@Column(name="manufactureCompany")
	private String manufactureCompany;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getManufactureCompany() {
		return manufactureCompany;
	}
	public void setManufactureCompany(String manufactureCompany) {
		this.manufactureCompany = manufactureCompany;
	}
	
	
	public Products(int pid, String pname, double pprice, String manufactureCompany) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.manufactureCompany = manufactureCompany;
	}
	
	public Products()
	{
		
	}
	@Override
	public String toString() {
		return "Products {pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", manufactureCompany="
				+ manufactureCompany + "}";
	}
	
	
	

}
