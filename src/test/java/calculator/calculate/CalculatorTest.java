package calculator.calculate;

import static calculator.calculate.Calculator.getNumSum;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("sumArrayTestCases")
    @DisplayName("int 배열을 순회하며 모든 요소들을 더한다. 단, 빈 배열인 경우 0을 반환한다.")
    void testGetResult(int[] arr, int expectedSum) {
        Assertions.assertEquals(expectedSum, getNumSum(arr));
    }

    static Stream<Arguments> sumArrayTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{}, 0)
        );
    }
}
