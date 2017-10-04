package demo;

import extensions.AnnotationParameterResolver;
import extensions.CustomAnnotation;
import extensions.CustomType;
import extensions.CustomTypeParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({AnnotationParameterResolver.class, CustomTypeParameterResolver.class})
public class MethodInjectionExample {

    @Test
    @DisplayName("Method Injection")
    void methodInjectionTest(TestInfo testName, TestReporter testReporter, CustomType customType,
                             @CustomAnnotation(value = "testvalue") String value) {
        assertEquals("Method Injection", testName.getDisplayName());
        assertNotNull(customType);
        assertNotNull(value);
        assertEquals("testvalue", value);
        testReporter.publishEntry("argument passed", value);
    }
}
