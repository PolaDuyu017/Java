package com.DH.file.conf;

import com.DH.file.User;
import com.DH.file.UserRepository;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
	
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
}
