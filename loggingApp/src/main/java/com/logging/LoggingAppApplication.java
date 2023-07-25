package com.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.logging.Dao.DaoMsg;
import com.logging.service.MessageService;

@SpringBootApplication
public class LoggingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingAppApplication.class, args);
	
MessageService ms=new MessageService();
ms.greetMessage();
ms.WelcomeMessage();

DaoMsg dm=new DaoMsg();
dm.getMessage();

}
}
