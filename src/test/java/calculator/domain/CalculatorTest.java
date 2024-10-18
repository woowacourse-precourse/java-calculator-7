package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @DisplayName("기본 구분자 쉼표로 실행에 성공한다.")
    @Test
    void 기본_구분자_쉼표_성공() {
        String input = "1,2,3";
        int expectedSum = 6;

        Calculator calculator = new Calculator(input);
        int result = calculator.sum();

        assertEquals(result, expectedSum);
    }

    @DisplayName("기본 구분자 콜론으로 실행에 성공한다.")
    @Test
    void 기본_구분자_콜론_성공() {
        String input = "1:2:3";
        int expectedSum = 6;

        Calculator calculator = new Calculator(input);
        int result = calculator.sum();

        assertEquals(result, expectedSum);
    }

    @DisplayName("기본 구분자 쉼표와 콜론으로 실행에 성공한다.")
    @Test
    void 기본_구분자_쉼표_콜론_성공() {
        String input = "1,2:3";
        int expectedSum = 6;

        Calculator calculator = new Calculator(input);
        int result = calculator.sum();

        assertEquals(result, expectedSum);
    }

    @DisplayName("커스텀 구분자로 실행에 성공한다.")
    @Test
    void 커스텀_구분자__성공() {
        String input = "//;\\n1;2;3";
        int expectedSum = 6;

        Calculator calculator = new Calculator(input);
        int result = calculator.sum();

        assertEquals(result, expectedSum);
    }

    @DisplayName("기본 구분자와 커스텀 구분자가 함께 있을 때 실행에 성공한다.")
    @Test
    void 기본_구분자_커스텀_구분자_성공() {
        String input = "//;\\n1,2;3:4";
        int expectedSum = 10;

        Calculator calculator = new Calculator(input);
        int result = calculator.sum();

        assertEquals(result, expectedSum);
    }

}