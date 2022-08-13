package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	/*para falar que a classe vai ser um recurso Rest , precisamos colocar ja no começo da classe o Override*/
	
	/*para dizer que o metodo vai ser um rest , precisamos colocar o override*/
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity< List<User>>findAll(){
		User maria = new User("1", "Maria", "maria@gmail.com");
		User alex = new User("2", "Alex", "alex@gmail.com");
		List<User>list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}

}