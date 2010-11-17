package com.serge.cv;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serge.cv.dao.UserDao;


@Controller
@RequestMapping(value="/users", method=RequestMethod.GET)
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserControllers {

	private static final Logger logger = LoggerFactory.getLogger(UserControllers.class);

	@Autowired private UserDao userDao;
	
	@RequestMapping(value="/add.do")
	
	public String addUser(@RequestParam(value="login", required=true) String login,
						  @RequestParam(value="password", required=false) String password, ModelMap model) {
		User user = this.userDao.persist(new User(login, password ));
		model.put("user", user);
		logger.info("add user "+user);
		return "user";
	}
	
	@RequestMapping(value="/{login}")
	@Transactional(readOnly = true)
	public String getUser(@PathVariable(value="login") String login, ModelMap model) {
		User user = this.userDao.findbyLogin(login);
		model.put("user", user);
		logger.info("add user "+user);
		return "user";
	}
	
	@RequestMapping(value="/{login}/json")
	public @ResponseBody User  getJsonUser(@PathVariable(value="login") String login) {
		User user = this.userDao.findbyLogin(login);
		logger.info("add user "+user);
		return user;
	}
	
}

