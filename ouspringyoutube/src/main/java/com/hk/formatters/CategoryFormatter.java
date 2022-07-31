package com.hk.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.hk.pojo.Category;

public class CategoryFormatter implements Formatter<Category> {

	@Override
	public String print(Category object, Locale locale) {
		// TODO Auto-generated method stub
		return String.valueOf(object.getId());
	}

	@Override
	public Category parse(String id, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		Category c = new Category();
        c.setId(Integer.parseInt(id));
        
        return c;
	}

}
