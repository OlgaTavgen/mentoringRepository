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

//@Component
@RequestMapping("/hogwarts")
public class HogwartsController 
{	
	@Autowired
	@Qualifier("hogwartsService")
	public HogwartsService hogwartsService;
	
	public HogwartsController(){
	}
	
	public HogwartsService getHogwartsService() {
		return hogwartsService;
	}

	public void setHogwartsService(HogwartsService hogwartsService) {
		this.hogwartsService = hogwartsService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView hogwartsWelcome()
	{
		ModelAndView model = new ModelAndView("home");
		model.addObject("msg", "Welcome Hogwarts!");
		
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public HogwartsResultsResponseDTO retrieveResults(@RequestParam(required = true) final String team)
	{
		final HogwartsRequest request = hogwartsService.forTeam(team);
		final HogwartsResultsResponse response = request.retrieveResults();
		
		return new HogwartsResultsResponseDTO(response);
	}
}
