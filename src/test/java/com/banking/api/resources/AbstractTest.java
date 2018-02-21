package com.banking.api.resources;

/**
 * Created by Master on 2/21/2018.
 */
import javafx.application.Application;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * The AbstractTest class is the parent of all JUnit test classes. This class
 * configures the test ApplicationContext and test runner environment.
 *
 * @author Matt Warman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = Application.class)
@WebAppConfiguration

public abstract class AbstractTest {

    /**
     * The Logger instance for all classes in the unit test framework.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
