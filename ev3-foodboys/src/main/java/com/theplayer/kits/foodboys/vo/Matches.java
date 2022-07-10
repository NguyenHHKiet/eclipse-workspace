package com.theplayer.kits.foodboys.vo;

import java.sql.Date;

public class Matches {
	private int matches_id;
	private Date matches_date;
	private int home_team;
	private int away_team;
	private int home_score;
	private int away_score;
	private boolean matches_status;
	
	public int getMatches_id() {
		return matches_id;
	}
	public void setMatches_id(int matches_id) {
		this.matches_id = matches_id;
	}
	public Date getMatches_date() {
		return matches_date;
	}
	public void setMatches_date(Date matches_date) {
		this.matches_date = matches_date;
	}
	public int getHome_team() {
		return home_team;
	}
	public void setHome_team(int home_team) {
		this.home_team = home_team;
	}
	public int getAway_team() {
		return away_team;
	}
	public void setAway_team(int away_team) {
		this.away_team = away_team;
	}
	public int getHome_score() {
		return home_score;
	}
	public void setHome_score(int home_score) {
		this.home_score = home_score;
	}
	public int getAway_score() {
		return away_score;
	}
	public void setAway_score(int away_score) {
		this.away_score = away_score;
	}
	public boolean isMatches_status() {
		return matches_status;
	}
	public void setMatches_status(boolean matches_status) {
		this.matches_status = matches_status;
	}
	
	
	
}
