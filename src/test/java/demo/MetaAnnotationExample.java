package demo;

import extensions.DisabledTest;
import extensions.TimingTest;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MetaAnnotationExample {

    @TimingTest
    void someTest(TestInfo context) {
        assertTrue(context.getTags().contains("timing"));
    }

    @DisabledTest
    void disabledTest(TestInfo context) {
        assertTrue(false,"it won't fail anyway");
    }
}
