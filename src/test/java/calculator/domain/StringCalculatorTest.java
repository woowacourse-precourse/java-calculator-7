package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

    // 테스트할 StringCalculator 인스턴스
    private StringCalculator calculator;

    // @BeforEach : 테스트 실행 전에 실행되어야하는 메서드
    @BeforeEach
    void setUp() {

        // 테스트 전 새로운 인스턴스
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 들어오면? 0 반환")
    void emptyStringReturnsZero() {
        // assertEquals: 예상 값과 실제 값이 같은지 검증
        // 첫 번째 인자: 예상 값, 두 번째 인자: 실제 값
        assertEquals(new Number(0), calculator.calculate(""));
    }

    @Test
    @DisplayName("하나의 숫자 입력되면 그대로 반환")
    void singleNumberReturnsValue() {
        assertEquals(new Number(1), calculator.calculate("1"));
    }


    @Test
    @DisplayName("쉼표로 구분된 예시")
    void twoNumbersCommaDelimitedReturnsSum() {
        assertEquals(new Number(3), calculator.calculate("1,2"));
    }

    @Test
    @DisplayName("클론로 구분된 예시")
    void twoNumbersColonDelimitedReturnsSum() {
        assertEquals(new Number(3), calculator.calculate("1:2"));
    }

    @Test
    @DisplayName("커스텀 구분자")
    void customDelimiterIsHandled() {
        assertEquals(new Number(3), calculator.calculate("//;\n1;2"));
    }


    @Test
    @DisplayName("0 이하의 숫자 입력")
    void negativeNumberThrowsException() {
        // assertThrows: 특정 예외가 발생하는지 검증
        // 첫 번째 인자: 예상되는 예외 클래스
        // 두 번째 인자: 람다식으로 표현된 실행될 코드
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,-2,3"));
    }

    @Test
    @DisplayName("유효하지 않은 입력")
    void invalidInputThrowsException() {
        assertThrows(NumberFormatException.class, () -> calculator.calculate("1,a"));
    }
}
