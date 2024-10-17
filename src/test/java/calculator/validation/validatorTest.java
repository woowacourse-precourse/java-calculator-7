package calculator.validation;

import calculator.Type.MessageType;
import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class validatorTest {

    @Test
    @DisplayName("숫자가 구분자로 들어갔을 때 예외를 발생시킨다")
    void 숫자가_구분자로() throws Exception{
        String input="//3\\n12";
        assertThatThrownBy(()-> Validator.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.NUMBER_SEPERATOR.getMessage());
    }

    @Test
    void 커스텀구분자가_아닌_구분자_존재() throws Exception{
        String input="1:2!,3";
        assertThatThrownBy(()-> Validator.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.INVALID_SEPERATOR.getMessage());
    }

}