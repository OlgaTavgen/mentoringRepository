package com.mentoringproject.hogwarts.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;
import com.mentoringproject.hogwarts.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.model.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.model.HogwartsTask;
import com.shared.model.XMLTagsLocators;

@Component
public class HogwartsEntryFactory
{	
	private final static String DEVELOPERS_XML_PATH = "src/main/resources/xml/developer.xml";
	private final static String TASKS_XML_PATH = "src/main/resources/xml/task.xml";
	
	public List<HogwartsDeveloper> createDevelopersFromXML(final HogwartsResultsResponse response)
	{
		List<HogwartsDeveloper> developers = Lists.newArrayList();
		
		try
		{						
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(new File(DEVELOPERS_XML_PATH));
		
			doc.getDocumentElement().normalize();
		
			NodeList teamsList = doc.getElementsByTagName(XMLTagsLocators.TEAM);
		
			for(int teamCount=0; teamCount<teamsList.getLength(); teamCount++)
			{
				Node teamNode = teamsList.item(teamCount);
				Element teamElement = (Element) teamNode;
			
				if(teamElement.getAttribute(XMLTagsLocators.TEAM_NAME_ATTR).equals(response.getTeam()))
				{
					final NodeList developersList = doc.getElementsByTagName(XMLTagsLocators.DEVELOPER);
				
					for(int devCount=0; devCount<developersList.getLength(); devCount++)
					{
						Node developerNode = developersList.item(devCount);					
						Element developerElement = (Element)developerNode;
					
						final String firstName = developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_FIRSTNAME).toString();	
						final String lastName = developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_LASTNAME).toString();	
						final String nickname = developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_NICKNAME).toString();	
						final String primarySkill = developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_PRIMARYSKILL).toString();	
					
						final HogwartsDeveloper  developer = new HogwartsDeveloper();
					
						developer.setFirstName(firstName);
						developer.setLastName(lastName);
						developer.setNickname(nickname);
						developer.setPrimarySkill(primarySkill);
					
						developers.add(developer);
					}					
				}		
			}
		
			return developers;			
		}
		
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		
		catch (SAXException se)
		{
			se.printStackTrace ();
		} 
		
		catch (IOException ioe)
		{
			ioe.printStackTrace ();
		} 
		
		return developers;
	
	}
	
	public List<HogwartsTask> createTasksFromXML()
	{
		List<HogwartsTask> tasks = Lists.newArrayList();
				
		try
		{						
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(new File(TASKS_XML_PATH));
		
			doc.getDocumentElement().normalize();
		
			NodeList tasksList = doc.getElementsByTagName(XMLTagsLocators.TASK);
		
			for(int taskCount=0; taskCount<tasksList.getLength(); taskCount++)
			{
				Node taskNode = tasksList.item(taskCount);
				Element taskElement = (Element) taskNode;
			
				final String id = taskElement.getAttribute(XMLTagsLocators.TASK_ID_ATTR).toString();
				final String type = taskElement.getElementsByTagName(XMLTagsLocators.TASK_TYPE).toString();	
				final String description = taskElement.getElementsByTagName(XMLTagsLocators.TASK_DESCRIPTION).toString();	
				final String estimate = taskElement.getElementsByTagName(XMLTagsLocators.TASK_ESTIMATE).toString();	
				final String priority = taskElement.getElementsByTagName(XMLTagsLocators.TASK_PRIORITY).toString();
				final String severity = taskElement.getElementsByTagName(XMLTagsLocators.TASK_SEVERITY).toString();	
					
				final HogwartsTask task = new HogwartsTask();
					
				task.setId(id);
				task.setType(type);
				task.setDescription(description);
				task.setEstimate(estimate);
				task.setPriority(priority);
				task.setSeverity(severity);
					
				tasks.add(task);					
			}
		
			return tasks;	
		}
		
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		
		catch (SAXException se)
		{
			se.printStackTrace ();
		} 
		
		catch (IOException ioe)
		{
			ioe.printStackTrace ();
		} 
		
		return tasks;
	}
}
