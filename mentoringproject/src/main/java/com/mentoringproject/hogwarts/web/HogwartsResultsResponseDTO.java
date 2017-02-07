package com.mentoringproject.hogwarts.web;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.mentoringproject.hogwarts.model.HogwartsResultsResponse;

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
	private HogwartsDeveloperItemDTO developers;
	
	@JsonProperty
	private HogwartsTaskItemDTO tasks;
	
	public HogwartsResultsResponseDTO(final String team)
	{
		this.team = team;
	}
	
	public HogwartsResultsResponseDTO(final HogwartsResultsResponse results)
	{
		team = results.getTeam();
		developers = new HogwartsDeveloperItemDTO(results.getDeveloperItem());
		tasks = new HogwartsTaskItemDTO(results.getTaskItem());
	}

	public String getTeam()
	{
		return team;
	}

	public HogwartsDeveloperItemDTO getDevelopers()
	{
		return developers;
	}

	public HogwartsTaskItemDTO getTasks() 
	{
		return tasks;
	}
}
