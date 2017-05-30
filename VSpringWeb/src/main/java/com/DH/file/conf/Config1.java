package com.DH.file.conf;

import com.DH.file.AuthFailLogger;
import com.DH.file.AuthenticationService;
import com.DH.file.PasswordChangeService;
import com.DH.file.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public PasswordChangeService pwChangeSvc(){
		return new PasswordChangeService(userRepository);
	}
	
	@Bean
	public AuthFailLogger authFailLogger(){
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean
	public AuthenticationService authenticationService(){
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository);
		return authSvc;
	}
}
