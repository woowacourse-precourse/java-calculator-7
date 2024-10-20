package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator(new DelimiterManager());

    @Test
    void 빈_문자열_입력_처리_테스트() {
        String input = "";
        Assertions.assertThat(inputValidator.isEmptyInput(input)).isTrue();
    }

}