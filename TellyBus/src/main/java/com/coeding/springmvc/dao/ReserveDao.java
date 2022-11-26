package com.coeding.springmvc.dao;

import java.util.List;

import com.coeding.springmvc.entity.Reserve;

public interface ReserveDao {
	void reserve(Reserve reserve);

	List<Reserve> getReserve(String username);
}
