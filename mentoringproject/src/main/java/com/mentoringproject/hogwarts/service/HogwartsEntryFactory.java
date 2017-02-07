package com.mentoringproject.hogwarts.service;



import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mentoringproject.hogwarts.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.model.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.model.HogwartsTask;

@Component
public class HogwartsEntryFactory {
	
	public List<HogwartsDeveloper> createDevelopersFromXML(final HogwartsResultsResponse response)
	{
		List<HogwartsDeveloper> developers = Lists.newArrayList();
		
		return developers;
	}
	
	public List<HogwartsTask> createTasksFromXML()
	{
		List<HogwartsTask> tasks = Lists.newArrayList();
		
		return tasks;
	}
}
