package com.hk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pojo.Category;
import com.hk.repository.CategoryRepository;
import com.hk.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.categoryRepository.getCategories();
	}

}
