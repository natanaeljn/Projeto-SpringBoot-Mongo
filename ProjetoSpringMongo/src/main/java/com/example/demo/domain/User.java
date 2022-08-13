package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="user" )
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@org.springframework.data.annotation.Id
	private String Id;
	private String name;
	private String email;
	
	public User() {
		
	}

	public User(String id, String name, String email) {
		
		Id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Id, other.Id);
	}
	/*Serializable e um padrao para que os objetos trafeguem em bytes pelas redes*/
}
