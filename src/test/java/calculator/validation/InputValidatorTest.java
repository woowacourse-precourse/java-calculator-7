package calculator.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력값이 공백으로 시작했을 경우")
    @Test
    public void validateStartBlankTest() {
        //given
        String input = " 1,2,3,4";

        //then
        assertThatThrownBy(() -> InputValidator.validateStartBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 형식에서 '\\n'이 없을 경우 예외를 발생")
    @Test
    public void validateCustomSecondTest() {
        //given
        String input = "//%1%2%3%4";

        //then
        assertThatThrownBy(() -> InputValidator.validateCustomSecond(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 형식에서 구분자가 2개 이상일 경우 예외를 발생")
    @Test
    public void validateCustomLengthTest() {
        //given
        String input = "// -\n1 2 3 4";

        //then
        assertThatThrownBy(() -> InputValidator.validateCustomLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 문자열에 숫자 이외의 문자가 포함된 경우")
    @Test
    public void validateNumberOnlyTest() {
        //given
        String input1 = "//%\n1%2% %4";  // 공백이 포함됨
        String input2 = "1,a,3:4";  // 문자가 포함됨

        //then
        assertThatThrownBy(() -> InputValidator.validateNumberOnly(input1)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.ONLY_NUMBER.getMessage());
        assertThatThrownBy(() -> InputValidator.validateNumberOnly(input2)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.ONLY_NUMBER.getMessage());
    }

    @DisplayName("입력된 문자열에 음수가 포함된 경우")
    @Test
    public void validateNumberNegativeTest() {
        //given
        String input = "//%\n-1%2%3%4";

        //then
        assertThatThrownBy(() -> InputValidator.validateNumberOnly(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_ALLOW_NEGATIVE.getMessage());
    }

    @DisplayName("구분자 없이 숫자만 연속으로 입력된 경우")
    @Test
    public void validateContinuousNumbersTest() {
        //given
        String input = "//%\n1324";

        //then
        assertThatThrownBy(() -> InputValidator.validateContinuousNumbers(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.MISS_SEPARATOR.getMessage());
    }

    @DisplayName("기본 구분자와 커스텀 구분자 외의 구분자가 포함된 경우")
    @Test
    public void validateInvalidDelimiterTest() {
        //given
        String input1 = "//%\n1%3%2@4";  // 커스텀 구분자 사용
        String input2 = "1,2:3@4";  // 기본 구분자 사용

        //then
        assertThatThrownBy(() -> InputValidator.validateInvalidDelimiter(input1)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_DEFINE_CUSTOM_SEPARATOR.getMessage());
        assertThatThrownBy(() -> InputValidator.validateInvalidDelimiter(input2)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_DEFINE_CUSTOM_SEPARATOR.getMessage());
    }

    @DisplayName("입력된 문자열에 숫자 0이 포함된 경우")
    @Test
    public void splitCustomInput() {
        //given
        String input1 = "1,13,0:4";  // 0이 단독으로 입력된 경우
        String input2 = "//%\n1%13%000%4";  // 000처럼 0이 연속으로 입력된 경우

        //then
        assertThatThrownBy(() -> InputValidator.validateZero(input1)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_ALLOW_ONLY_ZERO.getMessage());
        assertThatThrownBy(() -> InputValidator.validateZero(input2)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_ALLOW_ONLY_ZERO.getMessage());
    }
}