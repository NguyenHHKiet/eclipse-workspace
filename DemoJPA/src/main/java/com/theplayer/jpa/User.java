package com.theplayer.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte active;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private String phone;

	@Column(name="user_role")
	private String userRole;

	private String username;

	//bi-directional many-to-one association to SaleOrder
	@OneToMany(mappedBy="user")
	private List<SaleOrder> saleOrders;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SaleOrder> getSaleOrders() {
		return this.saleOrders;
	}

	public void setSaleOrders(List<SaleOrder> saleOrders) {
		this.saleOrders = saleOrders;
	}

	public SaleOrder addSaleOrder(SaleOrder saleOrder) {
		getSaleOrders().add(saleOrder);
		saleOrder.setUser(this);

		return saleOrder;
	}

	public SaleOrder removeSaleOrder(SaleOrder saleOrder) {
		getSaleOrders().remove(saleOrder);
		saleOrder.setUser(null);

		return saleOrder;
	}

}