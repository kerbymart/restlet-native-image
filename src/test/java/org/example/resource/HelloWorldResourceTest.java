package org.example.resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.restlet.resource.ResourceException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HelloWorldResourceTest {

    private HelloWorldResource helloWorldResource;

    @Before
    public void setUp() {
        helloWorldResource = Mockito.spy(new HelloWorldResource());
    }

    @Test
    public void testDoInitWithNameParameter() throws ResourceException {
        // Mock the getQueryValue method to return "Restlet" when the "name" parameter is requested
        when(helloWorldResource.getQueryValue("name")).thenReturn("Restlet");

        // Invoke doInit using reflection or by calling a testable method that exposes it
        helloWorldResource.doInit();

        // Assert that the "name" field is initialized to "Restlet"
        assertEquals("hello, Restlet", helloWorldResource.sayHello());
    }

    @Test
    public void testDoInitWithoutNameParameter() throws ResourceException {
        // Mock the getQueryValue method to return null when the "name" parameter is requested
        when(helloWorldResource.getQueryValue("name")).thenReturn(null);

        // Invoke doInit using reflection or by calling a testable method that exposes it
        helloWorldResource.doInit();

        // Assert that the "name" field is initialized to "world"
        assertEquals("hello, world", helloWorldResource.sayHello());
    }
}