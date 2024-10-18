package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("사용자 입력 값이 없을 때 예외가 발생한다.")
    @Test
    void 사용자_입력_X() {
        String input = "";

        assertThatThrownBy(() -> new Calculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 값이 null일 때 예외가 발생한다.")
    @Test
    void 사용자_입력_null() {
        String input = null;

        assertThatThrownBy(() -> new Calculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 값에 기본 구분자, 커스텀 구분자가 없을 때 예외가 발생한다.")
    @Test
    void 사용자_입력_구분자_X() {
        String input = "1";

        assertThatThrownBy(() -> new Calculator(input).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 커스텀 구분자를 지정 못할 경우 예외가 발생한다.")
    @Test
    void 사용자_커스텀_구분자_실패() {
        String input = "\\n1;2;3";

        assertThatThrownBy(() -> new Calculator(input).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 커스텀 구분자가 기본 구분자 쉽표 일 때 예외가 발생한다.")
    @Test
    void 사용자_커스텀_구분자_기본_구분자_쉼표_실패() {
        String input = "//,\\n1,2,3";

        assertThatThrownBy(() -> new Calculator(input).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 커스텀 구분자가 기본 구분자 콜론 일 때 예외가 발생한다.")
    @Test
    void 사용자_커스텀_구분자_기본_구분자_콜론_실패() {
        String input = "//:\\n1,2,3";

        assertThatThrownBy(() -> new Calculator(input).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 커스텀 구분자가 기본 구분자 빈문자열 일 때 예외가 발생한다.")
    @Test
    void 사용자_커스텀_구분자_기본_구분자_빈문자열_실패() {
        String input = "//:\\n1,2,3";

        assertThatThrownBy(() -> new Calculator(input).sum())
                .isInstanceOf(IllegalArgumentException.class);
    }

}