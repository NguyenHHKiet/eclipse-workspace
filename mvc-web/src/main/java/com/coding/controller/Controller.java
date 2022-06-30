package com.coding.controller;

import java.util.Map;

public interface Controller {
	/**
	 * 
	 * @param model - shared data with Servlet
	 * @return viewUrl
	 */
	String execute(Map<String, Object> model) throws Exception;

}
