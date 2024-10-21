package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private Delimiter delimiter;
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        delimiter = new DefaultDelimiter();
        inputValidator = new InputValidator(delimiter);
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 문자열 입력에 정상 동작")
    void testStartsWithNumber() {
        //given
        String input = "1:2,3";
        //when
        String result = inputValidator.validate(input);
        //then
        assertEquals("6", result);
    }

    @Test
    @DisplayName("커스텀 구분자가 있으면 정상 동작")
    void testStartsWithCustomDelimiter() {
        //given
        delimiter = new CustomDelimiter();
        inputValidator = new InputValidator(delimiter);
        String input = "//.\\n1:2,3.4";
        //when
        String result = inputValidator.validate(input);
        //then
        assertEquals("10", result);
    }

    @Test
    @DisplayName("빈 문자열 입력시 0 반환")
    void testEmptyString() {
        //given
        String input = "";
        //when
        String result = inputValidator.validate(input);
        //then
        assertEquals("0", result);
    }

    @Test
    @DisplayName("유효하지 않은 입력 시 예외 발생")
    void testInvalidInput() {
        assertThrowsOnInvalidInput("abc,1,2,3");
        assertThrowsOnInvalidInput("-abc,1,2,3");
        assertThrowsOnInvalidInput(".abc,1,2,3");
    }

    private void assertThrowsOnInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validate(input));
    }
}
