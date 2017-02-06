package com.shared.service;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.shared.model.developers.Developer;
import com.shared.model.developers.DeveloperEnum;
import com.shared.model.teams.TeamEnum;

public class DeveloperDocumentXMLParser implements DocumentInterface {

	@Override
	public void buildDocument()
	{
		try
		{	
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document document = docBuilder.newDocument();
			Element projectElement = createElement(document, "project", "name", "Hogwarts");
			document.appendChild(projectElement);
			
			for (final TeamEnum team : TeamEnum.values())
			{
				Element teamElement = createElement(document, "team", "name", team.getName());
				projectElement.appendChild(teamElement);
				
				for (final DeveloperEnum dev : DeveloperEnum.values())
				{
					if (dev.getTeam().equals(team.getName()))
					{
						Developer developer = Developer.builder()
								.firstName(dev.getFirstName())
								.lastName(dev.getLastName())
								.nickname(dev.getFirstName(), dev.getLastName())
								.primarySkill(dev.getPrimarySkill())
								.build();
						
						final Element developerElement = createElement(document, "developer", "id", dev.getId());
						teamElement.appendChild(developerElement);
						
						final Element firstnameElement = document.createElement("firstname");
						firstnameElement.appendChild(document.createTextNode(developer.getFirstName()));
						developerElement.appendChild(firstnameElement);

						final Element lastnameElement = document.createElement("lastname");
						lastnameElement.appendChild(document.createTextNode(developer.getLastName()));
						developerElement.appendChild(lastnameElement);

						final Element nicknameElement = document.createElement("nickname");
						nicknameElement.appendChild(document.createTextNode(developer.getNickname()));
						developerElement.appendChild(nicknameElement);

						final Element primarySkillElement = document.createElement("primaryskill");
						primarySkillElement.appendChild(document.createTextNode(developer.getPrimarySkill()));
						developerElement.appendChild(primarySkillElement);
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("src/main/resources/xml/developer.xml"));

			// Output to console for testing
//			 StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);			
		}
		
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		catch (TransformerException tfe) 
		{
			tfe.printStackTrace();
		}
	}
}
