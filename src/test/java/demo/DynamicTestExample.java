package demo;

import extensions.DataSet;
import model.demo.Calculator;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestExample {

    private Calculator calculator = new Calculator();

    @TestFactory
    Collection<DynamicTest> testsFromCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test", () -> assertThrows(ArithmeticException.class, () -> {
                    int i = 10 / 0;
                })),
                dynamicTest("3rd dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }

    @TestFactory
    Stream<DynamicTest> testAdditionFromFile() {
        return DataSet.parseRuleFile("rules-addition.txt")
                .map(dataSet -> dynamicTest(displayName(dataSet, "+"),
                        evaluate(dataSet, calculator::add)));
    }

    @TestFactory
    Stream<DynamicTest> testSubtractionFromFile() {
        return DataSet.parseRuleFile("rules-subtraction.txt")
                .map(dataSet -> dynamicTest(displayName(dataSet, "-"),
                        evaluate(dataSet, calculator::subtract)));
    }

    private Executable evaluate(DataSet dataSet, BiFunction<Integer, Integer, Integer> function) {
        return () -> {
            int actualResult = function.apply(dataSet.getValueA(), dataSet.getValueB());
            assertEquals(dataSet.getExpectedResult(), actualResult);
        };
    }

    String displayName(DataSet dataSet, String operation) {
        return String.format("%s %s %s = %s", dataSet.getValueA(), operation, dataSet.getValueB(), dataSet.getExpectedResult());
    }

}