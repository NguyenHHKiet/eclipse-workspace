package com.theplayer.kits;

import java.util.HashMap;

public class ServletContextParam {

	private static HashMap<String, String> params;
	private static String uploadPath;

	public ServletContextParam() {
	}

	public String getParams(String key) {
		return params.get(key);
	}

	public ServletContextParam(HashMap<String, String> map) {
		this.params = map;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public ServletContextParam(String uploadPath) {
		this.uploadPath = uploadPath;
	}

}
