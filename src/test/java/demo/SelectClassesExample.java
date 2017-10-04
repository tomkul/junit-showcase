package demo;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({AssertionsTestExample.class, AssumptionsExample.class})
@SelectPackages("subpackage")
public class SelectClassesExample {
    //Does not work currently
}
