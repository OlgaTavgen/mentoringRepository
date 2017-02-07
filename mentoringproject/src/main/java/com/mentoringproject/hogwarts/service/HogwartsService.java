package com.mentoringproject.hogwarts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentoringproject.hogwarts.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.model.HogwartsDeveloperItem;
import com.mentoringproject.hogwarts.model.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.model.HogwartsTask;
import com.mentoringproject.hogwarts.model.HogwartsTaskItem;

@Service("hogwartsService")
public class HogwartsService
{
	@Autowired
	protected HogwartsEntryFactory hogwartsEntryFactory;
	
	public HogwartsRequest forTeam(final String team)
	{
		// need to be updated
		return new HogwartsRequest(team);
	}
	
	public class HogwartsRequest
	{
		private String team;
		
		public HogwartsRequest(final String team)
		{
			this.team = team;
		}
		
		public HogwartsResultsResponse retrieveResults()
		{
			final HogwartsResultsResponse response = new HogwartsResultsResponse(getTeam());
			
			response.setDeveloperItem(new HogwartsDeveloperItem());
			response.setTaskItem(new HogwartsTaskItem());
			
			populateResponseForTeam(response);
			
			return response;
		}

		public String getTeam()
		{
			return team;
		}
		
	}
	
	public void populateResponseForTeam(final HogwartsResultsResponse response)
	{
		final List<HogwartsDeveloper> developers = hogwartsEntryFactory.createDevelopersFromXML(response);
					
		final List<HogwartsTask> tasks = hogwartsEntryFactory.createTasksFromXML();
		
		response.getDeveloperItem().getDevelopers().addAll(developers);
		response.getTaskItem().getTasks().addAll(tasks);
	}

}
