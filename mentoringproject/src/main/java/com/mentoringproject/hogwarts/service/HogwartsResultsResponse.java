package com.mentoringproject.hogwarts.service;

import java.util.List;

public class HogwartsResultsResponse {
	
	private String team;
	
	private List<HogwartsDeveloper> developers;
	
	private List<HogwartsTask> tasks;
	
	//need to set a team name from UI somehow
	public HogwartsResultsResponse(final String team)
	{
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	public List<HogwartsDeveloper> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<HogwartsDeveloper> developers) {
		this.developers = developers;
	}

	public List<HogwartsTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<HogwartsTask> tasks) {
		this.tasks = tasks;
	}	
}
