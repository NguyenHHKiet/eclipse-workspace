package com.theplayer.kits.foodboys.vo;

import java.sql.Date;

public class Player {
	private int player_id;
	private String player_name;
	private Date player_birth;
	private String player_image;
	private int position_id;
	private int team_id;
	private int nation_id;
	private boolean player_status;
	
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public Date getPlayer_birth() {
		return player_birth;
	}
	public void setPlayer_birth(Date player_birth) {
		this.player_birth = player_birth;
	}
	public String getPlayer_image() {
		return player_image;
	}
	public void setPlayer_image(String player_image) {
		this.player_image = player_image;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getNation_id() {
		return nation_id;
	}
	public void setNation_id(int nation_id) {
		this.nation_id = nation_id;
	}
	public boolean isPlayer_status() {
		return player_status;
	}
	public void setPlayer_status(boolean player_status) {
		this.player_status = player_status;
	}
	
	
}
