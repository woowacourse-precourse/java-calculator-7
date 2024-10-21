package calculator.addcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {


    @Test
    @DisplayName("주어진 테스트 케이스1")
    void 커스텀_구분자_사용() {

        String inputString = "//;\\n1";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        assertEquals(stringAddCalculator.getResultString(), "1");
    }

    @Test
    @DisplayName("기본 구분자 사용 테스트")
    void basicDelimiterTest() {
        String inputString = "1,2:3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        assertEquals(stringAddCalculator.getResultString(), "6");
    }

    @Test
    @DisplayName("커스텀 구분자 사용 테스트")
    void customDelimiterTest() {
        String inputString = "//;\n1;2;3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        assertEquals(stringAddCalculator.getResultString(), "6");
    }

    @Test
    @DisplayName("다양한 구분자 사용 테스트")
    void manyDelimiterTest() {
        String inputString = "//;?\n123:234?345";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        assertEquals(stringAddCalculator.getResultString(), "702");
    }

    @Test
    @DisplayName("잘못된 문자 포함 예외 처리 테스트")
    void invalidCharacterTest() {
        String inputString = "1,2,a";
        assertThrows(IllegalArgumentException.class, () -> new StringAddCalculator(inputString));
    }

    @Test
    @DisplayName("음수 포함 예외 처리 테스트")
    void negativeNumberTest() {
        String inputString = "1,-2,3";
        assertThrows(IllegalArgumentException.class, () -> new StringAddCalculator(inputString));
    }

    @Test
    @DisplayName("구분자만 있는 경우 예외 처리 테스트")
    void delimiterOnlyTest() {
        String inputString = "//;\n;;";
        assertThrows(IllegalArgumentException.class, () -> new StringAddCalculator(inputString));
    }

    @Test
    @DisplayName("구분자가 끝에 위치한 경우 예외 처리 테스트")
    void delimiterAtEndTest() {
        String inputString = "1,2,3,";
        assertThrows(IllegalArgumentException.class, () -> new StringAddCalculator(inputString));
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 테스트")
    void invalidCustomDelimiterTest() {
        String inputString = "//;\n1;2;";
        assertThrows(IllegalArgumentException.class, () -> new StringAddCalculator(inputString));
    }

    @Test
    @DisplayName("혼합된 기본 구분자 사용 테스트")
    void mixedBasicDelimiterTest() {
        String inputString = "1,2:3";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        assertEquals(stringAddCalculator.getResultString(), "6");
    }

    @Test
    @DisplayName("여러 개의 커스텀 구분자 사용 테스트")
    void multipleCustomDelimiterTest() {
        String inputString = "//;|*\n1;2|3*4";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(inputString);
        assertEquals(stringAddCalculator.getResultString(), "10");
    }
}
