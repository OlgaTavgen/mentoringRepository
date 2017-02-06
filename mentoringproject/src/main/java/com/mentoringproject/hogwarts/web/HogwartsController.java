package com.mentoringproject.hogwarts.web;

import java.beans.EventHandler;

import javax.jws.WebService;
import javax.websocket.server.ServerEndpoint;
import javax.xml.ws.WebEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mentoringproject.hogwarts.service.HogwartsService;

@Controller
@RequestMapping("/hogwarts")
public class HogwartsController 
{	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView hogwartsWelcome()
	{
		ModelAndView model = new ModelAndView("home");
		model.addObject("msg", "Welcome Hogwarts!");
		
		return model;
	}
}
