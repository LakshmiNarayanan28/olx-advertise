package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="advertises")
public class Advertise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private int category;
	private String categoryName;
	private String status;
	private double price;
	private String description; 
	private String postedby;
	private String username;
	
	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Advertise(int id, String title, int category, String categoryName,String status, double price, String description,
			String postedby, String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.categoryName=categoryName;
		this.status = status;
		this.price = price;
		this.description = description;
		this.postedby = postedby;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String catStatus) {
		this.status = catStatus;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", category=" + category + ", categoryName="+ categoryName + ",status=" + status + ", price="
				+ price + ", description=" + description + ", postedby=" + postedby + ", username=" + username + "]";
	}
	
	
}
