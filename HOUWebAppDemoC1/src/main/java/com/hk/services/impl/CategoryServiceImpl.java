package com.hk.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pojo.Category;
import com.hk.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryRepository{

	@Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }
}
