package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorServiceTest {
    @Test
    @DisplayName("null 입력 시 예외를 발생시킨다.")
    void null_입력_예외_발생() {
        // Given
        CalculatorService calculatorService = new CalculatorService();

        // When, Then
        assertThatThrownBy(() -> calculatorService.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 없습니다.");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환한다.")
    void 빈_문자열_입력_시_0_반환() {
        // Given
        CalculatorService calculatorService = new CalculatorService();

        // When
        int result = calculatorService.calculate("");

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("기본 구분자를 사용한 합산 결과를 반환한다.")
    void 기본_구분자로_합산() {
        // Given
        CalculatorService calculatorService = new CalculatorService();

        // When
        int result = calculatorService.calculate("1,2:3");

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 합산 결과를 반환한다.")
    void 커스텀_구분자로_합산() {
        // Given
        CalculatorService calculatorService = new CalculatorService();

        // When
        int result = calculatorService.calculate("//;\\n1;2;3");

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 발생시킨다.")
    void 음수_포함_예외_발생() {
        // Given
        CalculatorService calculatorService = new CalculatorService();

        // When, Then
        assertThatThrownBy(() -> calculatorService.calculate("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 허용되지 않습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 경우 예외를 발생시킨다.")
    void 숫자_아닌_문자_포함_예외_발생() {
        // Given
        CalculatorService calculatorService = new CalculatorService();

        // When, Then
        assertThatThrownBy(() -> calculatorService.calculate("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }
}
