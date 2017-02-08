package com.mentoringproject.hogwarts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mentoringproject.hogwarts.model.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.service.HogwartsEntryFactory;
import com.mentoringproject.hogwarts.service.HogwartsService;
import com.mentoringproject.hogwarts.service.HogwartsService.HogwartsRequest;

@Controller
@RequestMapping("/hogwarts")
public class HogwartsController 
{	
	@Autowired
	@Qualifier("hogwartsService")
	public HogwartsService hogwartsService;

//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public ModelAndView hogwartsWelcome()
//	{
//		ModelAndView model = new ModelAndView("home");
//		model.addObject("msg", "Welcome Hogwarts!");
//		
//		return model;
//	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String hogwartsHomePage()
	{		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//	public HogwartsResultsResponseDTO retrieveResults(@RequestParam(required = true) final String team)
	public HogwartsResultsResponseDTO retrieveResults()
	{
		final String team = "Slytherin";
		final HogwartsRequest request = hogwartsService.forTeam(team);
		final HogwartsResultsResponse response = request.retrieveResults();
		
		return new HogwartsResultsResponseDTO(response);
	}
}
