package com.theplayer.kits.foodboys.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.theplayer.kits.foodboys.dao.AchievementDAO;
import com.theplayer.kits.foodboys.dao.FileDAO;
import com.theplayer.kits.foodboys.dao.LeagueDAO;
import com.theplayer.kits.foodboys.dao.ManagerDAO;
import com.theplayer.kits.foodboys.dao.MatchesDAO;
import com.theplayer.kits.foodboys.dao.PlayerDAO;
import com.theplayer.kits.foodboys.dao.TeamDAO;
import com.theplayer.kits.foodboys.dao.UserDAO;
import com.theplayer.kits.foodboys.vo.Achievement;
import com.theplayer.kits.foodboys.vo.League;
import com.theplayer.kits.foodboys.vo.Manager;
import com.theplayer.kits.foodboys.vo.Matches;
import com.theplayer.kits.foodboys.vo.Player;
import com.theplayer.kits.foodboys.vo.Team;
import com.theplayer.kits.foodboys.vo.User;


// author: Long & Hung & Phuong & Thinh & Kiet
@Service
public class FootBallService {
	
	
	private UserDAO userdao;
	private TeamDAO teamdao;
	private PlayerDAO playerdao;
	private MatchesDAO matchesdao;
	private AchievementDAO achievementdao;
	private LeagueDAO leaguedao;
	private ManagerDAO managerdao;
	private FileDAO filedao;
	
	
//For SERVICE
	public FootBallService() {
		userdao = new UserDAO();
		teamdao = new TeamDAO();
		playerdao = new PlayerDAO();
		matchesdao = new MatchesDAO();
		achievementdao = new AchievementDAO();
		leaguedao = new LeagueDAO();
		managerdao = new ManagerDAO();
		filedao = new FileDAO();
	}
	
	public List<Team> showTeam() {	
		List<Team> list = teamdao.showTeam();
		return list;	
	}
	
	public List<Player> showPlayer() {
		List<Player> list = playerdao.showPlayer();
		return list;	
	}
	public List<Matches> showMatches() {
		
		List<Matches> list = matchesdao.showMatches();
		
		return list;	
	}
	//------------------------------------------------------
	
//For Login
	public User checkUsername(String username) {
		User user = null;
		if(userdao.findUsername(username)!=null) {
			user = userdao.findUsername(username);
		}
		return user;
		
	}
	public User login(String username,String password) {
		User user = null;
		if(userdao.findAccount(username,password)!=null) {
			user = userdao.findUsername(username);
		}
		return user;
	}
//For USER
	public void insertUser(User user) {
		if(user!=null) {
			userdao.insert(user);
		}
	}
	
	public void updateUser(User user) {
		if(user!=null){
			userdao.update(user);
		}
	}
	
	public void deleteUser(User user) {
		if(user!=null) {
			userdao.delete(user);
		}
	}
	
	public void showUser() {
		userdao.selectList();
	}
	
	//	public void findUser(User user) {}
	
	public User findUser(String username) {
		User user = null;
		if(userdao.findUsername(username)!=null) {
			user = userdao.findUsername(username);
			if(user.isStatus()==true) {
				return user;
			}
		}
		return null;
	}
//For Team
	public void insertTeam(Team team) {
		if(team!=null) {
			teamdao.insert(team);
		}
	}
	
	public void updateTeam(Team team) {
		if(team!=null){
			teamdao.update(team);
		}
	}
	
	public void deleteTeam(Team team) {
		if(team!=null) {
			teamdao.delete(team);
		}
	}
	
//	public void showTeam() {
//		teamdao.selectList();
//	}
	
	//	public void findTeam(Team team) {}
	
	public Team findTeam(String team_name) {
		Team team = null;
		if(teamdao.findTeamName(team_name)!=null) {
			team = teamdao.findTeamName(team_name);
			if(team.isTeam_status()==true) {
				return team;
			}
		}
		return null;
	}
//For Matches
	public void insertMatches(Matches matches) {
		if(matches!=null) {
			matchesdao.insert(matches);
		}
	}
	
	public void updateMatches(Matches matches) {
		if(matches!=null){
			matchesdao.update(matches);
		}
	}
	
	//	public void findMatches(Matches matches) {}
	
//For Achievement
	public void insertAchievement(Achievement achievement) {
		if(achievement!=null) {
			achievementdao.insert(achievement);
		}
	}
	
	public void updateAchievement(Achievement achievement) {
		if(achievement!=null){
			achievementdao.update(achievement);
		}
	}
	
	public void deleteAchievement(Achievement achievement) {
		if(achievement!=null) {
			achievementdao.delete(achievement);
		}
	}
	
	public void showAchievement() {
		achievementdao.selectList();
	}
	
//For League
	public void insertLeague(League league) {
		if(league!=null) {
			leaguedao.insert(league);
		}
	}
	
	public void updateLeague(League league) {
		if(league!=null){
			leaguedao.update(league);
		}
	}
	
	public void showLeague() {
		leaguedao.selectList();
	}
//For manager
	public void insertManager(Manager manager) {
		if(manager!=null) {
			managerdao.insert(manager);
		}
	}
	
	public void updateManager(Manager manager) {
		if(manager!=null){
			managerdao.update(manager);
		}
	}
	
	public void deleteManager(Manager manager) {
		if(manager!=null) {
			managerdao.delete(manager);
		}
	}
	
	public void showManager() {
		managerdao.selectList();
	}
	
	//	public void findManager(Manager manager) {}
	
	public Manager findManager(String manager_name) {
		Manager manager = null;
		if(managerdao.findManagerName(manager_name)!=null) {
			manager = managerdao.findManagerName(manager_name);
			if(manager.isManager_status()==true) {
				return manager;
			}
		}
		return null;
	}
//For Player
	public void insertPlayer(Player player) {
		if(player!=null) {
			playerdao.insert(player); //service call dao
		}
	}
	
	public void updatePlayer(Player player) {
		if(player!=null){
			playerdao.update(player);
		}
	}
	
	public void deletePlayer(Player player) {
		if(player!=null) {
			playerdao.delete(player);
		}
	}

//	public void showPlayer() {
//		playerdao.selectList();
//	}
	
	//	public void findPlayer(Player player) {}
	
	public Player findPlayer(String player_name) {
		Player player = null;
		if(playerdao.findPlayerName(player_name)!=null) {
			player = playerdao.findPlayerName(player_name);
			if(player.isPlayer_status()==true) {
				return player;
			}
		}
		return null;
	}
	public int ImagesPlayer(MultipartFile file, Player player) {
		System.out.println(123);
		String img = filedao.store(file);
		if(img!=null) {
			player.setPlayer_image(img);
			playerdao.update(player);
		}
		return 0;
	}

	public Object searchPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
