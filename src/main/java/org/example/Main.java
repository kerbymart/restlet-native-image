package org.example;

import org.example.resource.HelloWorldResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application{

    private static final int HTTP_PORT = 8080;

    public static void main(final String[] args) throws Exception {
        // Set up and start the main application component, binding it to an HTTP server on port 8080.
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, HTTP_PORT);
        component.getDefaultHost().attach("", new Main());
        component.start();
    }

    @Override
    public Restlet createInboundRoot() {

        Router router = new Router(getContext());
        router.attach("/hello", HelloWorldResource.class);
        return router;
    }
}