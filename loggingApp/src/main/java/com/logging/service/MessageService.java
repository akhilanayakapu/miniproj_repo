package com.logging.service;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class MessageService {
	
	Logger logger=LoggerFactory.getLogger(MessageService.class);
	public String WelcomeMessage() {
		logger.debug("welcomeMessage()-started ");
		String msg="welcome to java";
		logger.debug("welcomeMessage()-ended ");
		return msg;
	}
  public String greetMessage() {
	  logger.debug("greetMessage()-started ");
	  String msgg="good morng";
	  logger.debug("greetMessage()-ended ");
	  return msgg;
  }
}
