package com.DH.file.conf;

import java.util.Arrays;

import com.DH.file.AuthFailLogger;
import com.DH.file.AuthenticationService;
import com.DH.file.PasswordChangeService;
import com.DH.file.User;
import com.DH.file.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public User user1(){
		return new User("bkchoi", "1234");
	}
	
	@Bean(name="user2")
	public User user(){
		return new User("madvirus", "qwer");
	}
	
	@Bean
	public UserRepository userRepository(){
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;
	}
	
	@Bean
	public PasswordChangeService pwChangeSvc(){
		return new PasswordChangeService(userRepository());
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
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}
}
