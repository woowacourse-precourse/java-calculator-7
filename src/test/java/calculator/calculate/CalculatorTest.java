package calculator.calculate;

import static calculator.calculate.Calculator.getResult;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("int 배열을 순회하며 모든 요소들을 더한다.")
    void testGetResult() {
        int[] arr = new int[]{1, 2, 3};

        Assertions.assertEquals(6, getResult(arr));
    }

    @Test
    @DisplayName("배열이 빈 경우 결과로 0을 반환한다.")
    void getEmptyArrResult() {
        int[] arr = new int[0];

        Assertions.assertEquals(0, getResult(arr));
    }
}