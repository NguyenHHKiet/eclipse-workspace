package com.hk.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Product.findAll", query = "select p from Product p"),
	@NamedQuery(name = "Product.findById", query = "select p from Product p where p.id = :id"),
	@NamedQuery(name = "Product.findByName", query = "select p from Product p where p.name = :name"),
	@NamedQuery(name = "Product.findByDescription", query = "select p from Product p where p.description = :description")
})
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4659472681175345851L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int price;
	private String manufacturer;
	private String image;
	private Date created_date;
	private int active;
	private Category category_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Category getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}
	
}
