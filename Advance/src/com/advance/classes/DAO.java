package com.advance.classes;

public interface DAO<T>{

	void create(T arg);
	T read(int id);
	void update(T arg);
	int delete(int id);
}
