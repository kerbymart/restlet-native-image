package org.example.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {
    private String name;

    @Override
    protected void doInit() throws ResourceException {
        this.name = getQueryValue("name");
        if (this.name == null) {
            this.name = "world";  // default to "world" if no name is provided
        }
    }

    @Get
    public String sayHello() {
        return "hello, " + this.name;
    }
}