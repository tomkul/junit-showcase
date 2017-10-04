package demo;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@IncludeEngines("junit-jupiter")
//@IncludeTags({"fast", "flow"})
//@IncludePackages("demo")
//@IncludeClassNamePatterns(value = "^.*Example?$")
//@SelectPackages("demo")
@SelectClasses({JUnit4Example.class, TestHierarchyNestedExample.class, ParameterizedTestExample.class})
public class SelectTagsExample {
//Does not work currently
}
