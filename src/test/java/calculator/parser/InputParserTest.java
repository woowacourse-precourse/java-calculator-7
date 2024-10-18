package calculator.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.IllegalArgumentExceptionEnum;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {
    static InputParser inputParser;

    @BeforeAll
    static void setUp() {
        inputParser = new InputParser.Builder().setDefaultDelimiter(",:").setCustomDelimiterFormat("//", "\\n").build();
    }

    @Test
    @DisplayName("기본 구분자를 사용하여 입력 문자열 파싱 성공")
    void parseWithDefaultDelimitersSuccessfully() {
        ArrayList<Integer> numbers = inputParser.parse("1,2,3");
        ArrayList<Integer> expectedNumbers = new ArrayList<>(List.of(1, 2, 3));

        assertIterableEquals(expectedNumbers, numbers);
    }

    @Test
    @DisplayName("커스텀 구분자를 포함한 문자열 파싱 성공")
    void parseWithSingleCustomDelimiterSuccessfully() {
        ArrayList<Integer> numbers = inputParser.parse("//a\\n1,2a3");
        ArrayList<Integer> expectedNumbers = new ArrayList<>(List.of(1, 2, 3));

        assertIterableEquals(expectedNumbers, numbers);
    }

    @Test
    @DisplayName("두 개 이상의 커스텀 구분자가 있을 때 예외 발생")
    void parseWithMultipleCustomDelimitersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> inputParser.parse("//a\\n1,2a3//b\\n"),
                IllegalArgumentExceptionEnum.MULTIPLE_DELIMITERS.getMessage());
    }

    @Test
    @DisplayName("빈 문자열 입력 시 빈 리스트 반환")
    void parseWithEmptyInputReturnsEmptyList() {
        assertEquals(0, inputParser.parse("").size());
    }

    @Test
    @DisplayName("입력 문자열이 구분자로 시작할 때 예외 발생")
    void parseWithLeadingDelimiterThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> inputParser.parse(",1,2,3"),
                IllegalArgumentExceptionEnum.EMPTY_TOKEN.getMessage());
    }

    @Test
    @DisplayName("연속된 구분자가 있을 때 예외 발생")
    void parseWithConsecutiveDelimitersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> inputParser.parse("1,,,2,3"),
                IllegalArgumentExceptionEnum.EMPTY_TOKEN.getMessage());
    }

    @Test
    @DisplayName("다양한 커스텀 구분자를 사용하여 파싱 성공")
    void parseWithMultipleCustomDelimiterFormatsSuccessfully() {
        ArrayList<Integer> numbers = inputParser.parse("//a\\n1:2,3a4a5");
        ArrayList<Integer> expectedNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        assertIterableEquals(expectedNumbers, numbers);
    }

    @Test
    @DisplayName("연속된 커스텀 구분자가 있을 때 예외 발생")
    void parseWithConsecutiveCustomDelimitersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> inputParser.parse("//a\\n1:2,3a4aaa5a"),
                IllegalArgumentExceptionEnum.EMPTY_TOKEN.getMessage());
    }
}
