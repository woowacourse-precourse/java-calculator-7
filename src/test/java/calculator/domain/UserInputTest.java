package calculator.domain;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {

    @Test
    void 구분자가_숫자이면_예외_발생(){
        String input="//3\\n123";

        assertThatThrownBy(()->new UserInput(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.NUMBER_SEPERATOR.getMessage());
    }

    @Test
    void 구분자가_빼기면_예외_발생(){
        String input="//-\\n123";

        assertThatThrownBy(()->new UserInput(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.MINUS_SEPERATOR.getMessage());
    }

    @Test
    void 음수를_입력했을때_예외_발생(){
        String input="//!\\n-34";

        assertThatThrownBy(()->new UserInput(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.NEGATIVE_INPUT.getMessage());
    }





}