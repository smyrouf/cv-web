package com.serge.cv.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serge.cv.User;

@Controller
@RequestMapping(value="/sample")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class ResumeController {
	
	@RequestMapping(value="/default",method=RequestMethod.GET)
	public  String login( ModelMap model) throws MessagingException, IOException   {
		return "/type/normal";
	}

}
