package com.mentoringproject.hogwarts.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.google.common.collect.Lists;
import com.mentoringproject.hogwarts.service.HogwartsDeveloper;
import com.mentoringproject.hogwarts.service.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.service.HogwartsTask;

@JsonAutoDetect(
		creatorVisibility = Visibility.NONE,
		fieldVisibility = Visibility.NONE,
		getterVisibility = Visibility.NONE,
		isGetterVisibility = Visibility.NONE,
		setterVisibility = Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HogwartsResultsResponseDTO {
	
	@JsonProperty
	private String team;
	
	@JsonProperty
	private List<HogwartsDeveloperDTO> developers = Lists.newArrayList();
	
	@JsonProperty
	private List<HogwartsTaskDTO> tasks = Lists.newArrayList();
	
	public HogwartsResultsResponseDTO(final String team)
	{
		this.team = team;
	}
	
	public HogwartsResultsResponseDTO(final HogwartsResultsResponse results)
	{
		final List<HogwartsDeveloperDTO> devDTOs = Lists.newArrayList();
		final List<HogwartsTaskDTO> taskDTOs = Lists.newArrayList();
		
		team = results.getTeam();
		
		for (final HogwartsDeveloper  developer : results.getDevelopers())
		{			
			final HogwartsDeveloperDTO developerDTO = new HogwartsDeveloperDTO(developer);
			
			devDTOs.add(developerDTO);			
		}
		
		developers = devDTOs;
		
		for (final HogwartsTask task: results.getTasks())
		{			
			final HogwartsTaskDTO taskDTO = new HogwartsTaskDTO(task);
			
			taskDTOs.add(taskDTO);			
		}
		
		tasks = taskDTOs;		
	}

	public String getTeam()
	{
		return team;
	}

	public List<HogwartsDeveloperDTO> getDevelopers()
	{
		return developers;
	}

	public List<HogwartsTaskDTO> getTasks() 
	{
		return tasks;
	}
}
