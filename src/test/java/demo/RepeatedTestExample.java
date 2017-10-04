package demo;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestExample {

    @RepeatedTest(10)
    void repeatedTest() {
        assertTrue(true);
    }
}
