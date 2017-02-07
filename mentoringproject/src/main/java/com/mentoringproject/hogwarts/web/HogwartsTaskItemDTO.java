package com.mentoringproject.hogwarts.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.mentoringproject.hogwarts.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.model.HogwartsTask;
import com.mentoringproject.hogwarts.model.HogwartsTaskItem;

public class HogwartsTaskItemDTO {
	
	@JsonProperty
	private List<HogwartsTaskDTO> tasks = Lists.newArrayList();
	
	public HogwartsTaskItemDTO(final HogwartsTaskItem item)
	{
		final List<HogwartsTaskDTO> taskDTOs = Lists.newArrayList();
		
		for (final HogwartsTask task: item.getTasks())
		{			
			final HogwartsTaskDTO taskDTO = new HogwartsTaskDTO(task);
			
			taskDTOs.add(taskDTO);			
		}
		
		tasks = taskDTOs;
	}
	
	public List<HogwartsTaskDTO> getTasks() 
	{
		return tasks;
	}
}
