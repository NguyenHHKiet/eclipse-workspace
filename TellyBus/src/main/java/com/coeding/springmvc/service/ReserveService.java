package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Reserve;

public interface ReserveService {
	void reserve(Reserve reserve);

	List<Reserve> getReserve(String username);
}
