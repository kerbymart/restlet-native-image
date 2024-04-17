package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.util.logging.Logger;

import static org.junit.Assert.fail;

public class MainTest {

    final static Logger LOG = Logger.getLogger(MainTest.class.getName());

    private Component component;

    @Before
    public void setUp() throws Exception {
        // Set up the Restlet component and start it
        component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);
        component.getDefaultHost().attach(new Main());
        component.start();
    }

    @After
    public void tearDown() throws Exception {
        // Stop the Restlet component
        component.stop();
    }

    /**
     * Test to exercise the hello resource to generate the native image configuration files
     * under the target/classes/META-INF/native-image directory.
     */
    @Test
    public void testHelloResource() {
        try {
            ClientResource client = new ClientResource("http://localhost:8182/hello?name=world");
            Representation representation = client.get();
            String response = representation.getText();

            LOG.info("Response: " + response);

            // Check if the response indicates an error in deserialization
            Assert.assertTrue("The response should indicate an error occurred.", response.contains("hello, world"));
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }
}
