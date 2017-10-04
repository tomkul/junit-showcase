package demo;

import extensions.MockFieldInjector;
import model.demo.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockFieldInjector.class)
public class PostProcessorInjectionExample {

    @Mock
    private Calculator calculator;

    @Test
    public void shouldBeAbleToStubBehaviourOfInjectedMock() throws Exception {
        when(calculator.multiply(anyInt(), anyInt())).then(invocation -> 30);
        assertEquals(30, calculator.multiply(15, 2));
    }
}
