package com.theplayer.kits.foodboys.vo;

import java.sql.Date;

public class Team {
	private int team_id;
	private String team_name;
	private Date team_founded;
	private String team_stadium;
	private int manager_id;
	private int league_id;
	private boolean team_status;
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public Date getTeam_founded() {
		return team_founded;
	}
	public void setTeam_founded(Date team_founded) {
		this.team_founded = team_founded;
	}
	public String getTeam_stadium() {
		return team_stadium;
	}
	public void setTeam_stadium(String team_stadium) {
		this.team_stadium = team_stadium;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLeague_id() {
		return league_id;
	}
	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}
	public boolean isTeam_status() {
		return team_status;
	}
	public void setTeam_status(boolean team_status) {
		this.team_status = team_status;
	}
	
	
	
}
