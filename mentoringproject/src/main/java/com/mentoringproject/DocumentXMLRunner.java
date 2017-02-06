package com.mentoringproject;

import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;

public class DocumentXMLRunner {
	
	public static void main(String args[])
	{
		new DeveloperDocumentXMLParser().buildDocument();
		new TaskDocumentXMLParser().buildDocument();
	}

}
