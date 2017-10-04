package demo.subpackage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCaseInSubpackage {

    @Test
    @Tag("fast")
    void testToShowHowRenderedInSubpackage() {
        assertTrue(true);
    }
}
