package demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Backwards compatibility guaranteed by <link>{@link org.junit.vintage.engine.VintageTestEngine}</link>
 */
@RunWith(Parameterized.class)
public class JUnit4Example {

    @Test
    public void testOverflow() {
        assertEquals(Integer.MIN_VALUE, Integer.MAX_VALUE + 1);
    }

    @Test
    @Ignore
    public void skippedTest() {
        // no-op
    }

    @Test
    public void testNumbers() {
        assertEquals(expected, (Integer) Integer.parseInt(actual), "number should be equal");
    }

    @Parameterized.Parameter
    public String actual;

    @Parameterized.Parameter(1)
    public Integer expected;

    @Parameterized.Parameters(name = "test for {0} + {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"0", 0}, {"1", 1}, {"2", 2}, {"3", 3}, {"4", 4}, {"5", 5}, {"6", 6}, {"7", 7}});
    }


}
