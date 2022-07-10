package com.theplayer.kits.foodboys.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// author: Long
public class LogAdvice {
	private Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	public void printLog() {
		logger.info("LOG {}", this);
		// how to get remote ip address ?
		// how to storage into DB ?
	}

}
