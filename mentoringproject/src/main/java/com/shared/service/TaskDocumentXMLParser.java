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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.shared.model.developers.Developer;
import com.shared.model.developers.DeveloperEnum;
import com.shared.model.tasks.Task;
import com.shared.model.tasks.TaskEnum;
import com.shared.model.teams.TeamEnum;

public class TaskDocumentXMLParser implements DocumentInterface {

	@Override
	public void buildDocument() {
		
		try
		{	
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document document = docBuilder.newDocument();
			Element backlogElement = createElement(document, "backlog", "name", "Hogwarts Backlog");
			document.appendChild(backlogElement);
			
			for (final TaskEnum taskEnum : TaskEnum.values())
			{
				Element taskElement = createElement(document, "task", "id", taskEnum.getId());
				backlogElement.appendChild(taskElement);
			
				Task task = Task.builder()
						.description(taskEnum.getDescription())
						.estimate(taskEnum.getEstimate())
						.priority(taskEnum.getPriority())
						.severity(taskEnum.getSeverity())
						.build();
											
				final Element descriptionElement = document.createElement("description");
				descriptionElement.appendChild(document.createTextNode(task.getDescription()));
				taskElement.appendChild(descriptionElement);

				final Element estimateElement = document.createElement("estimate");
				estimateElement.appendChild(document.createTextNode(task.getEstimate()));
				taskElement.appendChild(estimateElement);

				final Element priorityElement = document.createElement("priority");
				priorityElement.appendChild(document.createTextNode(task.getPriority()));
				taskElement.appendChild(priorityElement);

				final Element severityElement = document.createElement("severity");
				severityElement.appendChild(document.createTextNode(task.getSeverity()));
				taskElement.appendChild(severityElement);			
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("src/main/resources/xml/task.xml"));

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
