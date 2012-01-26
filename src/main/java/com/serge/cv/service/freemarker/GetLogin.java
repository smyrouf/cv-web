package com.serge.cv.service.freemarker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.serge.cv.User;
import com.serge.cv.service.UserContextService;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class GetLogin implements TemplateMethodModel {
	
	@Autowired UserContextService userContextService;

	@Override
	public Object exec(List arguments) throws TemplateModelException {
		User user = this.userContextService.getCurrentUser();
		if ( user == null ) {
			return "-1";
		}
		return user.getLogin();
	}


}
