package com.serge.cv.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serge.cv.User;
import com.serge.cv.service.UserContextService;

@Controller
@RequestMapping(value="/user")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserController {
		
	@Autowired private UserContextService userContextService;

	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public   @ResponseBody Map<String,String> login( ModelMap model) throws MessagingException, IOException   {
		User user = this.userContextService.getCurrentUser();
		model.put("user", user);
		Map<String,String> response = new HashMap<String,String>();
		if (user == null ) {
			response.put("status","Ko");
			return   response;
		}
		response.put("login", user.getLogin());
		response.put("status","ok");
		return  response;
	}
	
	@RequestMapping(value="/failure",method=RequestMethod.GET)
	public   @ResponseBody Map<String,String> login() throws MessagingException, IOException   {
		Map<String,String> response = new HashMap<String,String>();
		response.put("message", "le login ou le mot de passe est incorrecte");
		response.put("status","Ko");
		return   response;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public   @ResponseBody Map<String,String> logout() throws MessagingException, IOException   {
		return   Collections.singletonMap("status", "ok");
	}
	

}
