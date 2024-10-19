package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("입력 문자열을 기본 구분자로 분리")
    void checkInputWithDelimiter() {
        String input = "1,2:3";
        calculator.start(input);

        String[] numberLists = calculator.getNumberLists(input);
        String[] expectedLists = {"1", "2", "3"};

        assertArrayEquals(numberLists, expectedLists);
    }

    @Test
    @DisplayName("문자열의 덧셈 결과값이 일치")
    void checkSum() {
        String input = "1,2:3";

        calculator.start(input);
        String[] numberLists = calculator.getNumberLists(input);
        int sum = calculator.getSum(numberLists);

        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 입력 문자열 분리")
    void checkInputWithCustomDelimiter() {
        String input = "//A\\n1A2A3";
        calculator.start(input);

        String[] numberLists = calculator.getNumberLists(input);
        String[] expectedLists = {"1", "2", "3"};

        assertArrayEquals(numberLists, expectedLists);
    }

    @Test
    @DisplayName("커스텀 구분자를 활용한 문자열의 덧셈 결과값이 일치")
    void checkSumWithCustomDelimiter() {
        String input = "//A\\n1A2A3";

        calculator.start(input);
        String[] numberLists = calculator.getNumberLists(input);
        int sum = calculator.getSum(numberLists);

        assertThat(sum).isEqualTo(6);
    }
}