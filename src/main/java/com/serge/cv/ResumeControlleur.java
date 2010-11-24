package com.serge.cv;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/users/{login}/resume/{resume}", method=RequestMethod.GET)
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class ResumeControlleur {

	
	
}
