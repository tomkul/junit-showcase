package demo;

import model.demo.Calculator;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssumptionsExample {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldTestOnlyOnWindows() throws Exception {
        Assumptions.assumeTrue(getCurrentEnvironment("Windows"), "Not on Windows");
        assertEquals(8, calculator.add(3, 5));
    }

    @Test
    public void shouldTestOnlyOnLinux() throws Exception {
        Assumptions.assumeTrue(getCurrentEnvironment("Linux"), "Not on Linux");
        assertEquals(8, calculator.add(3, 5));
    }

    private BooleanSupplier getCurrentEnvironment(String arch) {
        return () -> System.getProperty("os.name").startsWith(arch);
    }
}
