import org.example.MyFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FunctionClassTest {
    public MyFunction f = new MyFunction();

    @Test
    void testSquare_negNum() {
        // given:
        int original = -2;
        int expected = 4;
        int result = f.square(original);
        // expect:
        System.out.println("testSquare_negNum");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDiv_nullArgument_throwsException() {
        // given:
        final int x = 2;
        final int y = 0;
        // expect:
        System.out.println("testDiv_nullArgument_throwsException");
        assertThrows(ArithmeticException.class, () -> {
            f.div(x, y);
        });
    }

    @Test
    public void testDiv_noException() {
        // given:
        final int x = 2;
        final int y = 1;
        // expect:
        System.out.println("testDiv_noException");
        assertDoesNotThrow(() -> {
            f.div(x, y);
        });
    }

    @ParameterizedTest
    @MethodSource("factoryMethodWithArguments")
    void testWithFactoryMethodWithArguments(int num, int expected) {
        // given:
        int result = f.fact(num);
        // expect:
        System.out.println("testWithFactoryMethodWithArguments " + Integer.toString(num) + ",  " + Integer.toString(expected));
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> factoryMethodWithArguments() {
        return Stream.of(
                arguments(2, 2),
                arguments(5, 120)
        );
    }
}
