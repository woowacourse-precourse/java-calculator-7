package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 커스텀_구분자_검증() {
        // given
        String input = "//\n1,2,3";
        // when
        assertThatThrownBy(() -> validator.validateCustomDelimiter(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_DELIMITER_MSG);
    }

    @Test
    void 입력값이_비어있는_경우() {
        // given
        String input = "   ";  // 비어있는 입력
        // when
        assertThatThrownBy(() -> validator.validateInput(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_INPUT_MSG);
    }
}
