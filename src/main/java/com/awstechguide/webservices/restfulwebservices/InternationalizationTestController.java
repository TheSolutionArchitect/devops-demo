package com.awstechguide.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalizationTestController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/welcome/{msg}")
	public MessageBean getMessage(@PathVariable String msg) {
		return new MessageBean(String.format("Hello, %s", msg));
	}
	
	@GetMapping("/welcome")
	public String getLocaleMessage(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("message.welcome",null, locale);
	}
}
