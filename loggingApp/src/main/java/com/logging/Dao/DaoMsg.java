package com.logging.Dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoMsg {
	Logger logger=LoggerFactory.getLogger(DaoMsg.class);
	/*
	 * public String name(Integer id) { logger.info("name()-start"); String
	 * name="null"; if(id==101) { name= "john"; } else if(id==102) { name= "sas";}
	 * else{ return "invalid id";
	 * 
	 * } logger.info("name()-end"); return name;
	 * 
	 * }
	 */
	
	public String getMessage() {
		logger.info("getMessage()-start");
		String messge="hi akhila!!!";
		logger.info("getMessage()-end");
		return messge;
	}
    	}
    

