package com.serge.cv.controller;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serge.cv.Authorithy;
import com.serge.cv.Authorities;
import com.serge.cv.Status;
import com.serge.cv.User;
import com.serge.cv.dao.UserDao;
import com.serge.cv.email.ActivationEmail;
import com.serge.cv.service.UserContextService;
import com.serge.cv.service.UserContextServiceImpl;


@Controller
@RequestMapping(value="/register")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class RegisterController {




		private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

		@Autowired private UserDao userDao;
		
		@Autowired private ActivationEmail activationEmail;  
		
		@Autowired private PasswordEncoder passwordEncoder;
		
		@RequestMapping(value="/init",method=RequestMethod.POST)
		public @ResponseBody Map<String,String>  addUser(@RequestParam(value="login", required=true) String login,
							  @RequestParam(value="password", required=false) String password,@RequestParam(value="courriel", required=true) String email, ModelMap model
							  ,HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws MessagingException, IOException 
							  {
			Map<String,String> response = new HashMap<String,String>();
			if ( login.isEmpty() ) {
				response.put("message","Le login est manquant");
				response.put("status", "ko");
				return   response;
			}
			if ( null != this.userDao.findbyLogin(login) ) {
				response.put("message","Le login est deja utilise");
				response.put("status", "ko");
				return   response;
			}
			User user = this.userDao.persist(new User(login, passwordEncoder.encodePassword(password, null ), email, Status.INACTIVE ));
			// send a mail to confirm the registration
			user.setActivationkey(passwordEncoder.encodePassword(password, login ));
			model.put("user", user);
			activationEmail.sendActivation(model,httpRequest, httpResponse);
			response.put("message","Vous avez ete enregistre avec succes.");
			response.put("status", "ok");
			return   response;
		}
		
		@RequestMapping(value="/activate",method=RequestMethod.GET)
		public  String activate(@RequestParam(value="activationkey", required=true) String key, ModelMap model) throws MessagingException, IOException   {
			User user = this.userDao.findbyActivationKey(key);
			user.setStatus(Status.ACTIVE);
			user.addAuthorities(new Authorities(user, Authorithy.ROLE_USER));
			this.userDao.persist(user);
			model.put("user", user);
			return   "welcome";
		}
		
		
		@RequestMapping(value="/del",method=RequestMethod.POST)
		public @ResponseBody Map<String,String> delUser(@RequestParam(value="login", required=true) String login,
				@RequestParam(value="password", required=false) String password) {
			User user = this.userDao.findbyLogin(login);
			if ( !user.getPassword().equals(password)) {
				return Collections.singletonMap("status", "ko");
			}
			this.userDao.delete(user);
			logger.info("del user "+user);
			return Collections.singletonMap("status", "ok");
		}

		@Transactional(readOnly = true)
		@RequestMapping(value="/check",method=RequestMethod.POST)
		public @ResponseBody Map<String,String> check(@RequestParam(value="login", required=true) String login,
				@RequestParam(value="password", required=false) String password) {
			User user = this.userDao.findbyLogin(login);
			if (user == null || !user.getPassword().equals(password)) {
				logger.info("check  user "+user+ " ko ");
				Collections.singletonMap("status", "ko");
			}
			logger.info("check  user "+user+ " ok ");
			return Collections.singletonMap("status", "ok");
		}
		
		
		
	}

