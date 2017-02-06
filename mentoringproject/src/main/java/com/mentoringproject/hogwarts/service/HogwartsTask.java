package com.mentoringproject.hogwarts.service;

import org.apache.commons.lang.StringUtils;

public class HogwartsTask
{
	private String type = StringUtils.EMPTY;
	private String description = StringUtils.EMPTY;
	private String estimate = StringUtils.EMPTY;
	private String priority = StringUtils.EMPTY;
	private String severity = StringUtils.EMPTY;
	
	public String getType() 
	{
		return type;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public String getEstimate() 
	{
		return estimate;
	}
	
	public String getPriority() 
	{
		return priority;
	}
	
	public String getSeverity() 
	{
		return severity;
	}	
}
