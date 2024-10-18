package calculator.util;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력값의 유효성 검증 - 검증 성공")
    void validateInputFormat() {
        //given
        String input = "//;\\n1,2:3";

        //when
        //then
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("입력값의 유효성 검증 - 여러 커스텀 구분자를 입력한 경우")
    void validateInputFormatWithMultipleCustomDelimiter() {
        //given
        String input = "//;;\\n1,2:3";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("입력값의 유효성 검증 - //로 시작하나, \\n이 나오지 않는 경우")
    void validateInputFormatWithWrongFormatDelimiter() {
        //given
        String input = "//;1,2:3";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("입력값의 유효성 검증 - 정상 문자열이 여러번 나오는 경우")
    void validateInputFormatWithMultipleValidInput() {
        //given
        String input = "//;\\n1,2:3//;\\n1,2:3";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("문자열 리스트 숫자 리스트로 변환 - 빈 문자열이 있는 경우")
    void validateParsingStringToLongWithNULL() {
        //given
        List<String> input = Arrays.asList("1", "2", "3", "");

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateParsingStringToLong(input));
    }

    @Test
    @DisplayName("문자열 리스트 숫자 리스트로 변환 - 숫자가 아닌 문자가 들어있는 경우")
    void validateParsingStringToLongWithNotNumber() {
        //given
        List<String> input = Arrays.asList("1", "b", "3");

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateParsingStringToLong(input));
    }

    @Test
    @DisplayName("숫자 리스트가 양수로 이루어져 있는지 검증 - 모두 양수로 이루어져 있는 경우")
    void validatePositiveNumberList() {
        //given
        List<Long> input = Arrays.asList(1L, 2L, 3L);

        //when
        //then
        Assertions.assertDoesNotThrow(() -> inputValidator.validatePositiveNumberList(input));
    }

    @Test
    @DisplayName("숫자 리스트가 양수로 이루어져 있는지 검증 - 음수가 포함되어 있는 경우")
    void validatePositiveNumberListWithNegativeNumber() {
        //given
        List<Long> input = Arrays.asList(1L, -2L, 3L);

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validatePositiveNumberList(input));
    }
}