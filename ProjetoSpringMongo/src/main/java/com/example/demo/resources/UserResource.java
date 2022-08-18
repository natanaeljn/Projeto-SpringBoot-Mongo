package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	/*para falar que a classe vai ser um recurso Rest , precisamos colocar ja no começo da classe o Override*/
	
	/*para dizer que o metodo vai ser um rest , precisamos colocar o override*/
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity< List<UserDTO>>findAll(){
		/*desta forma buscamos no banco de dados e instanciamos na lista*/
		List<User>list =service.findAll();
		List<UserDTO>listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public ResponseEntity< UserDTO>findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	

}
