package com.serge.cv.email;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import sun.security.action.GetLongAction;

import com.serge.cv.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ActivationEmail {
	@Autowired private  JavaMailSenderImpl mailServer;
	
	@Autowired private  SimpleMailMessage mailActivationData;
	
	@Autowired private ViewResolver emailViewResolver;
	
	private String activationTemplate;


	public void setActivationTemplate(String activationTemplate) {
		this.activationTemplate = activationTemplate;
	}

	public String getActivationTemplate() {
		return activationTemplate;
	}
	
	public void sendActivation( final ModelMap model, final HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws MessagingException {
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailServer.createMimeMessage());
			View view = emailViewResolver.resolveViewName(this.activationTemplate, httpRequest.getLocale());
			HttpStringResponseWrapper httpServletResponseWrapper = new HttpStringResponseWrapper(httpResponse);
			view.render(model, httpRequest, httpServletResponseWrapper);
			messageHelper.setText(httpServletResponseWrapper.toString(),  true);
			messageHelper.setSubject(mailActivationData.getSubject());
			messageHelper.setTo(((User)model.get("user")).getEmail());
			mailServer.send(messageHelper.getMimeMessage());
		} catch ( IOException e) {
			throw new MessagingException(e.toString()); 
		}catch ( TemplateException e) {
			 
		} catch (Exception e) {
			throw new MessagingException(e.toString());
		}
	}
}
