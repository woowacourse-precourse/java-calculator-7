package calculator.domain.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 양수가_아닌_문자_테스트() {
        assertThat(inputValidator.isNonPositiveNumber("1")).isFalse();
        assertThat(inputValidator.isNonPositiveNumber("-1")).isTrue();
        assertThat(inputValidator.isNonPositiveNumber("0")).isTrue();
        assertThat(inputValidator.isNonPositiveNumber("000000000")).isTrue();
    }

    @Test
    void 입력_아무것도_없을_때_테스트() {
        assertThat(inputValidator.checkInputEmpty("")).isTrue();
        assertThat(inputValidator.checkInputEmpty("1")).isFalse();
    }

    @Test
    void 숫자가_아닌_문자_들어왔을_때_테스트() {
        assertThat(inputValidator.isValidNumber("1")).isTrue();
        assertThat(inputValidator.isValidNumber("a")).isFalse();
        assertThat(inputValidator.isValidNumber("\\")).isFalse();
        assertThat(inputValidator.isValidNumber("\n")).isFalse();
    }

}
