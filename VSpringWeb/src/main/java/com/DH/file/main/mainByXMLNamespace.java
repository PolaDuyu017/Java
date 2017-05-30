package com.DH.file.main;

import com.DH.file.AuthenticationService;
import com.DH.file.PasswordChangeService;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainByXMLNamespace {
	
	public static void main(String[] args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config.xml");
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
	}
}
