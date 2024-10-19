package calculator.domain;

import calculator.exception.InvalidInputException;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 구분자가_숫자이면_예외_발생(){
        String seperator="3";

        assertThatThrownBy(()->Validator.validateSeperator(seperator))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.NUMBER_SEPERATOR.getMessage());
    }

    @Test
    void 구분자가_빼기면_예외_발생(){
        String seperator="-";

        assertThatThrownBy(()->Validator.validateSeperator(seperator))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.MINUS_SEPERATOR.getMessage());

    }

    @Test
    void 음수를_입력했을때_예외_발생(){
        String input="//!\\n-34";

        assertThatThrownBy(()->Validator.validatePositive(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.NEGATIVE_INPUT.getMessage());

    }

    @Test
    void 존재하지_않는_커스텀구분자_예외_발생(){
        String input="~2";

        assertThatThrownBy(()->Validator.validateCustomSeperator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.INVALID_SEPERATOR.getMessage());
    }

}