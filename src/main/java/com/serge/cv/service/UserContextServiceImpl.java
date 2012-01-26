package com.serge.cv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.serge.cv.User;
import com.serge.cv.dao.UserDao;


@Service
public class UserContextServiceImpl implements UserContextService {

	@Autowired UserDao userDao;

	public User getCurrentUser() {
		String userName = null;
		if ( ( userName = SecurityContextHolder.getContext().getAuthentication().getName() ) == null ) {
			return null;
		}
		return this.userDao.findbyLogin(userName);
	}

}
