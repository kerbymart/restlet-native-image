package org.example.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;

public class HelloWorldResource extends org.restlet.resource.ServerResource {
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