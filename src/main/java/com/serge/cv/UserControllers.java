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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serge.cv.dao.UserDao;


@Controller
@RequestMapping(value="/users/{login}/", method=RequestMethod.GET)
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserControllers {

	private static final Logger logger = LoggerFactory.getLogger(UserControllers.class);

	@Autowired private UserDao userDao;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(@RequestParam(value="login", required=true) String login,
						  @RequestParam(value="password", required=false) String password, ModelMap model) {
		User user = this.userDao.persist(new User(login, password ));
		model.put("user", user);
		logger.info("add user "+user);
		return "user";
	}
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> delUser(@RequestParam(value="login", required=true) String login,
			@RequestParam(value="password", required=false) String password) {
		User user = this.userDao.findbyLogin(login);
		if ( !user.getPassword().equals(password)) {
			Collections.singletonMap("status", "ko");
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

