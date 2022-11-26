package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="bus")
public class Bus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2452826103918035122L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="dateleave")
	private Date dateLeave;
	
	
	@Column(name="datereturn")
	private Date dateReturn;
	
	@Column(name="leavingfrom")
	private String leaveFrom;
	
	@Column(name="goingto")
	private String goingTo;
	
	
	public Bus() {
		
	}

	





	public Bus(Date dateLeave, Date dateReturn, String leaveFrom, String goingTo) {
		this.dateLeave = dateLeave;
		this.dateReturn = dateReturn;
		this.leaveFrom = leaveFrom;
		this.goingTo = goingTo;
	
	}


	public Date getDateLeave() {
		return dateLeave;
	}





	public void setDateLeave(Date dateLeave) {
		this.dateLeave = dateLeave;
	}





	public Date getDateReturn() {
		return dateReturn;
	}





	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}





	public String getLeaveFrom() {
		return leaveFrom;
	}





	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}





	public String getGoingTo() {
		return goingTo;
	}





	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}





	@Override
	public String toString() {
		return "Bus [dateLeave=" + dateLeave + ", dateReturn=" + dateReturn + ", leaveFrom=" + leaveFrom + ", goingTo="
				+ goingTo + "]";
	}





	



	
	

}
