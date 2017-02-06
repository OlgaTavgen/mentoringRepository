package com.mentoringproject.hogwarts.service;

import org.apache.commons.lang.StringUtils;

public class HogwartsDeveloper {

	private String firstName = StringUtils.EMPTY;
	private String lastName = StringUtils.EMPTY;
	private String nickname = StringUtils.EMPTY;
	private String primarySkill = StringUtils.EMPTY;
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPrimarySkill()
	{
		return primarySkill;
	}
	
	public void setPrimarySkill(String primarySkill)
	{
		this.primarySkill = primarySkill;
	}

}
