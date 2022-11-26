package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.ReserveDao;
import com.coeding.springmvc.entity.Reserve;
import com.coeding.springmvc.service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReserveDao reserveDao;
	
	@Override
	public void reserve(Reserve reserve) {
		// TODO Auto-generated method stub
		this.reserveDao.reserve(reserve);
	}

	@Override
	public List<Reserve> getReserve(String username) {
		// TODO Auto-generated method stub
		return this.reserveDao.getReserve(username);
	}

}
