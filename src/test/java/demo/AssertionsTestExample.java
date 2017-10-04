package demo;

import model.demo.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTestExample {
    @Test
    @DisplayName("with succeeding assertAll")
    void assertAllTest() {
        Map<String, String> person = new HashMap<String, String>();
        person.put("firstName", "Luke");
        person.put("lastName", "Skywalker");
        person.put("planet", "Tatooine");
        assertAll("Check person",
                () -> assertEquals("Luke", person.get("firstName")),
                () -> assertEquals("Skywalker", person.get("lastName")),
                () -> assertEquals("Tatooine", person.get("planet"))
        );
    }

    @Test
    @DisplayName("example for failing with assertAll")
    void assertAllFailingTest() {
        Map<String, String> person = new HashMap<>();
        person.put("firstName", "Leia");
        person.put("lastName", "Organa");
        person.put("planet", "Alderaan");
        assertAll("Check person",
                () -> assertEquals("Leia", person.get("firstName")),
                () -> assertEquals("Organa", person.get("lastName")),
                () -> assertEquals("Hoth", person.get("planet"))
        );
    }

    @Test
    @DisplayName("hanging code")
    void testNeverEndingCode() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            while (true) {}
        });
    }

    @Test
    void testException() {
        Calculator calculator = new Calculator();
        Throwable exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Disabled
    @DisplayName("this won't be tested")
    void ignoredTest() {
        //noop
    }
}