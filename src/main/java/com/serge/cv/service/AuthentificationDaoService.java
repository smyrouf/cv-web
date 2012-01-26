package com.serge.cv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serge.cv.Authorities;
import com.serge.cv.dao.UserDao;

@Service
@Transactional
public class AuthentificationDaoService implements UserDetailsService {

	@Autowired private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		com.serge.cv.User user = this.userDao.findbyLogin(username);
		List<GrantedAuthorityImpl> GrantedAuthority = new ArrayList<GrantedAuthorityImpl>();
		if ( user == null ) {
			throw new UsernameNotFoundException("user "+user+"has not been founded.");
		}
		for ( Authorities auth : user.getAuthorities() ) {
			GrantedAuthority.add(new GrantedAuthorityImpl(auth.getAuthorithy().toString()));
		}
		 return new User(user.getLogin(), user.getPassword(), true,
				 true, true, true, GrantedAuthority);
	}
	
}
