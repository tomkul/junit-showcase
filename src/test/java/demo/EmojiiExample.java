package demo;

import model.demo.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EmojiiExample {

    @Test
    @Tag("fast")
    @DisplayName("test 😎")
    void testEmojiiRenderedProperly(TestInfo testInfo) {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals("test 😎", testInfo.getDisplayName(), "TestInfo is injected correctly");
    }

    @Test
    @Tag("slow")
    void testSlowCode() throws InterruptedException {
        Thread.sleep(1000);
    }

}
