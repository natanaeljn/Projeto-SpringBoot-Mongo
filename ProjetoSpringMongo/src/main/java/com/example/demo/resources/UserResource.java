package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	/*para falar que a classe vai ser um recurso Rest , precisamos colocar ja no começo da classe o Override*/
	
	/*para dizer que o metodo vai ser um rest , precisamos colocar o override*/
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity< List<User>>findAll(){
		/*desta forma buscamos no banco de dados e instanciamos na lista*/
		List<User>list =service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
