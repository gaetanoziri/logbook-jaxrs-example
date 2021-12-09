package com.aurigaspa.example.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestService {
	
	@GET
	@Path("hello/{name}/{surname}")
	@Produces(MediaType.TEXT_PLAIN)
	public String GetText(@PathParam("name") String name, @PathParam("surname") String surname) {
		return "hello " + name + " " + surname;
	}
	

	@POST
	@Path("hello")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String PostText(@FormParam(value = "name") String name, @FormParam(value = "surname") String surname) {
		return "hello " + name + " " + surname;
	}
	

}