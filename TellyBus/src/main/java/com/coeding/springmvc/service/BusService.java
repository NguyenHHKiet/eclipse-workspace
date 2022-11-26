package com.coeding.springmvc.service;

import java.sql.Date;
import java.util.List;

import com.coeding.springmvc.entity.Bus;

public interface BusService {

	void create(Bus bus);

	List<Bus> getAllUsers();

	List<Bus> getCity(String leaveFrom, String goingTo, Date dateLeave, Date dateReturn);
}
