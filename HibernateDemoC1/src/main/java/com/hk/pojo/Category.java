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



@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Category.findAll", query = "select c from Category c"),
	@NamedQuery(name = "Category.findById", query = "select c from Category c where c.id = :id"),
	@NamedQuery(name = "Category.findByName", query = "select c from Category c where c.name = :name"),
	@NamedQuery(name = "Category.findByDescription", query = "select c from Category c where c.description = :description")
})
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6773744844140455081L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
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
	
}
