package calculator.domain;

import static calculator.global.exception.ErrorMessage.EMPTY_INPUT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.global.exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @Test
    @DisplayName("유효한 입력 테스트")
    void testValidInput() {
        inputParser.parse("//,\\n1,2,3");

        assertEquals("//,", inputParser.getDelimiterString());
        assertEquals("1,2,3", inputParser.getInputString());
    }

    @Test
    @DisplayName("유효한 입력 테스트")
    void testValidInputOne() {
        inputParser.parse("//;\\n1");

        assertEquals("//;", inputParser.getDelimiterString());
        assertEquals("1", inputParser.getInputString());
    }

    @Test
    @DisplayName("유효한 입력 테스트 - 구분자 빈 값")
    void testValidInputNoDelimiter() {
        inputParser.parse("1,2,3");

        assertEquals("", inputParser.getDelimiterString());
        assertEquals("1,2,3", inputParser.getInputString());
    }

    @Test
    @DisplayName("잘못된 입력 테스트 - 빈 입력")
    public void testInvalidNoInputString() {
        String input = "";

        CalculatorException exception = assertThrows(CalculatorException.class, () -> {
            inputParser.parse(input);
        });

        assertEquals(EMPTY_INPUT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 입력 테스트 - NULL 입력")
    public void testInvalidNullInputString() {
        String input = null;

        CalculatorException exception = assertThrows(CalculatorException.class, () -> {
            inputParser.parse(input);
        });

        assertEquals(EMPTY_INPUT.getMessage(), exception.getMessage());
    }
}