package calculator.domain.calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringCalculatorServiceImplTest {

    private final StringCalculatorService calculatorService = StringCalculatorServiceImpl.getInstance();

    @Nested
    @DisplayName("문자열 계산기 서비스 테스트")
    class CalculateTests {

        @Test
        @DisplayName("기본 구분자로 구분된 숫자들의 합을 계산한다.")
        void calculateWithDefaultDelimiters() {
            assertEquals(6, calculatorService.calculate("1,2,3"));
            assertEquals(10, calculatorService.calculate("1:2:3:4"));
        }

        @Test
        @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 계산한다.")
        void calculateWithCustomDelimiter() {
            assertEquals(6, calculatorService.calculate("//;\\n1;2;3"));
            assertEquals(10, calculatorService.calculate("//@\\n1@2@3@4"));
        }

        @Test
        @DisplayName("빈 문자열 또는 null 입력 시 0을 반환한다.")
        void calculateWithEmptyOrNullInput() {
            assertEquals(0, calculatorService.calculate(""));
            assertEquals(0, calculatorService.calculate(null));
        }

        @Test
        @DisplayName("음수를 포함한 입력에 대해 예외를 발생시킨다.")
        void throwExceptionForNegativeNumbers() {
            assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate("1,-2,3"));
        }

        @Test
        @DisplayName("숫자가 아닌 입력에 대해 예외를 발생시킨다.")
        void throwExceptionForNonNumericInput() {
            assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate("1,a,3"));
        }
    }
}