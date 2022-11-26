package com.coeding.springmvc.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.BusDao;
import com.coeding.springmvc.entity.Bus;
import com.coeding.springmvc.service.BusService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao busDao;
	
	@Override
	public void create(Bus bus) {
		// TODO Auto-generated method stub
		this.busDao.create(bus);
	}

	@Override
	public List<Bus> getAllUsers() {
		// TODO Auto-generated method stub
		return this.busDao.getAllUsers();
	}

	@Override
	public List<Bus> getCity(String leaveFrom, String goingTo, Date dateLeave, Date dateReturn) {
		// TODO Auto-generated method stub
		return this.busDao.getCity(leaveFrom, goingTo, dateLeave, dateReturn);
	}

}
