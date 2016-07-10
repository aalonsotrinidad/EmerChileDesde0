package com.springsource.emergencias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsource.emergencias.domain.HerokuUser__c;
import com.springsource.emergencias.persistence.HerokuUserDao;
import com.springsource.emergencias.service.HerokuUserService;

@Service
public class HerokuUserServiceImpl implements HerokuUserService {
	
	  @Autowired 
	  private HerokuUserDao dao;
	  
	  public List<HerokuUser__c> findAll(){
		  return dao.findAll();
	  }
	  
	  public HerokuUser__c getUser(String username, String password){
		  return dao.getUser(username, password);
	  }
}
