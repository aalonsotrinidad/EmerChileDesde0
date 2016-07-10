package com.springsource.emergencias.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springsource.emergencias.domain.HerokuUser__c;
import com.springsource.emergencias.service.HerokuUserService;

@Controller
@RequestMapping("/")
public class LoginController {
  
	@Autowired
	private HerokuUserService herokuUserService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("login");
        HerokuUser__c loginBean = new HerokuUser__c();
        model.addObject("loginBean", loginBean);
        return model;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")HerokuUser__c loginBean){
    	ModelAndView model= null;
    	try{
	    	HerokuUser__c usuario = herokuUserService.getUser(loginBean.getUsername(), loginBean.getPassword());
		    if (usuario != null){
		    	System.out.println("Login correcto");
		    	request.setAttribute("loggedInUser", usuario.getUsername());
		    	//model = new ModelAndView("home");
		    }else{
	            model = new ModelAndView("login");
	            model.addObject("loginBean", loginBean);
	            request.setAttribute("message", "Credenciales erroneas");
		    	//model = new ModelAndView("errorLogin");
		    }
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
	    return model;
	}
}
