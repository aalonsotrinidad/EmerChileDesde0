package com.springsource.emergencias.service;

import java.util.List;

import com.springsource.emergencias.domain.HerokuUser__c;

public interface HerokuUserService{
	  public List<HerokuUser__c> findAll();
	  public HerokuUser__c getUser(String username, String password); 
}
