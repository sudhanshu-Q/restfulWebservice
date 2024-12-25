package com.rest.webservice.restful_Webservices.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	//to change message in different language
	private MessageSource messageSource;
	
	public HelloWorld(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/home")
	public Model helloworld(Model model) {;
		return model;
	}
	@RequestMapping(method = RequestMethod.GET,path = "/student")
	public Model navigateStudent(Model model) {;
		return model;
	}
	
	@GetMapping(path = "/helloworldbean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	//I18N different language
	@GetMapping(path = "/helloWorldLang")
	public String helloworldInternationalization() {
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
	}

}
