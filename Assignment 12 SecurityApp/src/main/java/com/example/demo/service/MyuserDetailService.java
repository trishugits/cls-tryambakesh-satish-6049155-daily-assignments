package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Myusers;
import com.example.demo.repository.MyusersRepo;
@Service
public class MyuserDetailService implements UserDetailsService {

	@Autowired
	private MyusersRepo myUserRepo;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Myusers> op = myUserRepo.findById(username);
		
		if(op.isPresent()) {
			Myusers user=op.get();
			return new MyUserDetail(user);
		}
		else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

}
