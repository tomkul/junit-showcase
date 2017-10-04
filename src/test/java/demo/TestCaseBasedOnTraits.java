package demo;

import extensions.Fast;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@DisplayName("A succeeding test case")
@Fast
@TestInstance(PER_CLASS)
public class TestCaseBasedOnTraits extends TestCaseBasedOnTraits$AbstractSuperTest implements TestCaseBasedOnTraits$ExtendingInterface {
    @Test
    public void testBase1() {
        System.out.println("testBase1");
    }

    @Test
    void testBase2() {
        System.out.println("testBase2");
    }
}

abstract class TestCaseBasedOnTraits$AbstractSuperTest {
    @Test
    void testFromAbstractSuperClass() {
        System.out.println("test from abstract class");
    }

    @Test
    void testBase2() {
        if (true) {
            throw new RuntimeException("test2 from superclass is shadowed");
        }
    }
}

interface TestCaseBasedOnTraits$SuperInterface {
    @Test
    default void testFromInterface() {
        System.out.println("test from super interface is shadowed");
    }
}

interface TestCaseBasedOnTraits$ExtendingInterface extends TestCaseBasedOnTraits$SuperInterface {
    @Test
    default void testFromInterface() {
        System.out.println("test from interface");
    }
}