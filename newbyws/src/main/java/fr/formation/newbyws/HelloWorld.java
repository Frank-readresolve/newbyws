package fr.formation.newbyws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("hello")
public class HelloWorld {

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String helloHTML() {
	return "<!DOCTYPE html><html><body>Hello world in HTML!</body></html>";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloJSON() {
	return "{\"message\":\"Hello world in JSON!\"}";
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String helloXML() {
	return "<message>Hello world in XML!</message>";
    }

    @GET
    @Path("/any/{type}")
    public Response hello(@PathParam("type") String type) {
	String content = null;
	String contentType = null;
	switch (type) {
	case "html":
	    content = "<!DOCTYPE html><html><body>Hello world in " + type
		    + "!</body></html>";
	    contentType = MediaType.TEXT_HTML;
	    break;
	case "json":
	    content = "{\"message\":\"Hello world in " + type + "!\"}";
	    contentType = MediaType.APPLICATION_JSON;
	    break;
	case "xml":
	    content = "<message>Hello world in " + type + "!</message>";
	    contentType = MediaType.APPLICATION_XML;
	    break;
	default:
	    throw new UnsupportedOperationException("unknown type: " + type);
	}
	ResponseBuilder builder = Response.ok(content);
	builder.header("Content-Type", contentType);
	return builder.build();
    }
}
