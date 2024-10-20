package calculator.domain;

import calculator.exception.InvalidInputException;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 존재하지_않는_커스텀구분자_예외_발생(){
        String input="~2";

        assertThatThrownBy(()->Validator.validateCustomSeperator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.INVALID_SEPERATOR.getMessage());
    }

}