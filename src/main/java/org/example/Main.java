package org.example;

import org.example.resource.HelloWorldResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class Main extends Application{

    private static final int HTTP_PORT = 8080;

    public static void main(final String[] args) throws Exception {
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