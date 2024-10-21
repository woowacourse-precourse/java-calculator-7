package calculator.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("올바른 형식의 커스텀 구분자 입력은 통과한다")
    void validCustomDelimiterFormatShouldPass() {
        String input = "//;\\n1;2;3";
        validator.validateFormat(input);
    }
}
