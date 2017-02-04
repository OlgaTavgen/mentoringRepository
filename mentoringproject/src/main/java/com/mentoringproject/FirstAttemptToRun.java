package com.mentoringproject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class FirstAttemptToRun {

	@GET
	@Produces("text/html")
	public Response getStartingPage()
	{
		String output = "<h1>First Attempt to run. Successful<h1>";
		return Response.status(200).entity(output).build();
	}
}
