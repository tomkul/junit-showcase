package demo;

import extensions.EnvironmentExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(EnvironmentExtension.class)
public class ConditionalTestsExample {

    @BeforeAll
    public static void setSystemProperty() {
        System.setProperty("env", "prod");
    }

    @Test
    void runOnlyIfSystemPropertySet() {
        assertTrue(true);
    }
}
