package com.springsource.emergencias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HerokuUser__c")
public class HerokuUser__c{
	
	//Id indica a hibernate que es la primary key
	//Indica con qué columna de la base de datos se corresponde cada variable.
	//Es buena práctica llamar a las variables igual que la columna en base de datos.
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="username__c")
	private String username;
	
	@Column(name="password__c")
	private String password;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
