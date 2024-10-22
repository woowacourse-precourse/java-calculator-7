package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.global.exception.CalculatorException;
import calculator.global.exception.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {
    private StringSplitter stringSplitter;

    @BeforeEach
    void setUp() {
        stringSplitter = new StringSplitter();
    }

    @Test
    @DisplayName("유효한 구분자와 문자 입력 테스트")
    void testValidInput() {
        String input = "1x2x3";
        String delimiter = "x";
        String[] expected = {"1", "2", "3"};
        assertArrayEquals(expected, stringSplitter.split(input, delimiter));
    }

    @Test
    @DisplayName("유효한 구분자와 한 문자 테스트")
    void testValidInputOne() {
        String input = "1";
        String delimiter = "x";
        String[] expected = {"1"};
        assertArrayEquals(expected, stringSplitter.split(input, delimiter));
    }

    @Test
    @DisplayName("잘못된 문자 입력 - 숫자로 시작하지 않는 경우")
    void testInvalidStart() {
        String input = "x1x2x3";
        String delimiter = "x";
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> stringSplitter.split(input, delimiter));
        assertEquals(ErrorMessage.INVALID_STRING_START.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 문자 입력 - 양수로 시작하지 않는 경우")
    void testInvalidStartA() {
        String input = "-1x2x3";
        String delimiter = "x";
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> stringSplitter.split(input, delimiter));
        assertEquals(ErrorMessage.INVALID_STRING_START.getMessage(), exception.getMessage());
    }

    @Test
    void 예외_테스트() {
        String input = "-1x2x3";
        String delimiter = "x";
        assertThatThrownBy(() -> stringSplitter.split(input, delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 문자 입력 - 숫자로 끝나지 않는 경우")
    void testInvalidEnd() {
        String input = "1x2x3x";
        String delimiter = "x";
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> stringSplitter.split(input, delimiter));
        assertEquals(ErrorMessage.INVALID_STRING_END.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 문자 입력 - 설정하지 않은 구분자 포함")
    void testInvalidCharacters() {
        String input = "1a2x3";
        String delimiter = "x";
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> stringSplitter.split(input, delimiter));
        assertEquals(ErrorMessage.INVALID_DELIMITER_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 문자 입력 - 빈 문자열")
    void testEmptyInput() {
        String input = "";
        String delimiter = "x";
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> stringSplitter.split(input, delimiter));
        assertEquals(ErrorMessage.EMPTY_NUMBER_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 문자 입력 - NULL 입력")
    void testNullInput() {
        String input = null;
        String delimiter = "x";
        CalculatorException exception = assertThrows(CalculatorException.class,
                () -> stringSplitter.split(input, delimiter));
        assertEquals(ErrorMessage.EMPTY_NUMBER_INPUT.getMessage(), exception.getMessage());
    }
}