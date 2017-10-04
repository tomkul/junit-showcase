package demo;

import model.demo.Calculator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTestExample {

    private Calculator calculator = new Calculator();

    static class CalculatorArguments implements Arguments {

        private final int operandA;
        private final int operandB;
        private final int result;

        CalculatorArguments(int operandA, int operandB, int result) {
            this.operandA = operandA;
            this.operandB = operandB;
            this.result = result;
        }

        @Override
        public Object[] get() {
            return new Integer[]{operandA, operandB, result};
        }
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    new CalculatorArguments(5, 7, 12),
                    new CalculatorArguments(8, 6, 14))
                    .map(Arguments::of);
        }
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithArgumentsProvider(CalculatorArguments parameters) {
        assertNotNull(parameters);
        assertEquals(calculator.add(parameters.operandA, parameters.operandB), parameters.result, "addition failed");
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.MATCH_ALL, names = "^(M|N).+SECONDS$")
    void testWithEnumSourceRegex(TimeUnit timeUnit) {
        String name = timeUnit.name();
        assertTrue(name.startsWith("M") || name.startsWith("N"));
        assertTrue(name.endsWith("SECONDS"));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    @ParameterizedTest
    @CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01.01.2017", "31.12.2017"})
    void testWithExplicitJavaTimeConverter(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate argument) {
        assertEquals(2017, argument.getYear());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv")
    void testWithCsvFileSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }
}
