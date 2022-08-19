package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.objectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo ;
	
	/*metodo para retornar todos os usuarios do banco de dados*/
	public List<User>findAll(){
		return repo.findAll();
		
		
	}
	/*metodo para verificar se existe o id */
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new objectNotFoundException("Objeto não encontrado"));
		}
	
	/*metodo para inserir*/
	public User inser(User obj) {
		return repo.insert(obj);
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
