package com.DH.file.main;

import com.DH.file.AuthenticationService;
import com.DH.file.PasswordChangeService;
import com.DH.file.conf.Config;
import com.DH.file.conf.Config1;
import com.DH.file.conf.Config2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainByJavaConfig {
	
	public static void main(String[] args){
		useSingleClass();
		useMultipleClass();
	}	
	
	private static void useSingleClass(){
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		useBean(ctx);
		ctx.close();
	}
	
	private static void useMultipleClass(){
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		useBean(ctx);
		ctx.close();
	}
	
	private static void useBean(AnnotationConfigApplicationContext ctx){
		
		AuthenticationService authSvc = 
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = 
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}
	
	
}
