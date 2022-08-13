package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo ;
	
	/*metodo para retornar todos os usuarios do banco de dados*/
	public List<User>findAll(){
		return repo.findAll();
		
		
	}

}
