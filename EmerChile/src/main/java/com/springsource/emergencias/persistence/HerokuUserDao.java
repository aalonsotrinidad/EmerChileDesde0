package com.springsource.emergencias.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsource.emergencias.domain.HerokuUser__c;

//Repository indica a Spring que es un beans y que forma parte del modelo. 
//Es equivalente a @Component, pero viene bien especificar a que parte pertenece.
@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class HerokuUserDao {
 
	//Autowired indica a Spring que sessionFactory tiene que inyectarlo
	@Autowired
	private SessionFactory sessionFactory;
 
	//Transaccional indica que la transacción o se completa entera o se hace rollback
	//En los select no es necesario, pero ya que se delega Hibernate a Spring hace falta.
	@Transactional
	public List<HerokuUser__c> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List listaUsuarios = session.createQuery("from HerokuUser__c").list();
		return listaUsuarios;
	}
	
	@Transactional
	public HerokuUser__c getUser(String username, String password) {
		HerokuUser__c usuario = null;
		Session session = sessionFactory.getCurrentSession();
		List<HerokuUser__c> listaUsuario = session.createQuery("from HerokuUser__c where usename__c = " + username + " and password__c = " + password).list();
		if (listaUsuario != null && !listaUsuario.isEmpty()){
			usuario = (HerokuUser__c)listaUsuario.get(0);
		}
		return usuario;
	}

}
