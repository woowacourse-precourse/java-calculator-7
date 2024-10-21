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
        String input = "//;\n1;2;3";

        // when & then
        validator.validateCustomDelimiterPattern(input);
    }

    @Test
    void 잘못된_커스텀_구분자_패턴() {
        // given
        String input = "//;\t1;2;";

        // when
        assertThatThrownBy(() -> validator.validateCustomDelimiterPattern(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_DELIMITER_MSG);
    }
}
