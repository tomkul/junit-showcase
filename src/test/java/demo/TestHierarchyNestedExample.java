package demo;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;

@RunWith(JUnitPlatform.class)
@TestInstance(PER_METHOD)
public class TestHierarchyNestedExample {

    private int i = 0;

    @Test
    public void topLevelTest1(TestInfo context) {
        i++;
        debug("top level", context);
    }

    @Test
    void topLevelTest2(TestInfo context) {
        i++;
        debug("top level", context);
    }

    @Nested
    @DisplayName("Second Level Context")
    @TestInstance(PER_CLASS)
    class SecondLevelTestContext {

        @Test
        void secondLevelTest1(TestInfo context) {
            i++;
            debug("second level", context);
        }

        @Test
        void secondLevelTest2(TestInfo context) {
            i++;
            debug("second level", context);
        }

        @Nested
        @DisplayName("Third Level Context")
        @TestInstance(PER_CLASS)
        class ThirdLevelTestContext {

            @Test
            void thirdLevelTest1(TestInfo context) {
                i++;
                debug("third level", context);
            }

            @Test
            void thirdLevelTest2(TestInfo context) {
                i++;
                debug("third level", context);
            }
        }
    }

    private void debug(String current, TestInfo context) {
        System.out.println(String.format("%s %s %s called, i has value %d",
                context.getTestMethod().map(Method::getName).orElse(""),
                current,
                getClass().getName(), i));
    }
}
