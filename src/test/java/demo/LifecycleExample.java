package demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LifecycleExample {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll called");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll called");
    }

    @BeforeEach
    void secondLevelBefore() {
        System.out.println("beforeEach called");
    }

    @AfterEach
    void secondLevelAfter() {
        System.out.println("afterEach called");
    }

    @Test
    void someTest1() {
        assertTrue(true);
    }

    @Test
    void someTest2() {
        assertTrue(true);
    }


}
