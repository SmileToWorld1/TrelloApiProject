package trello.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import trello.utilities.ConfigurationReader;

/**
 In this class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */
public class Hooks {
    final static Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("base_url");
        RestAssured.basePath = ConfigurationReader.getProperty("base_path");
        logger.info("@Before setup for API SERVER");
    }

    @After
    public void teardown(){
        logger.info("@After teardown for API SERVER");
    }

}


