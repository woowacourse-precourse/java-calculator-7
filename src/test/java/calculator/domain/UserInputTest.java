package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {


    @Test
    void 구분자가_숫자이면_예외_발생(){
        String input="//3\\n123";
        String NUMBER_SEPERATOR_INPUT="숫자를 구분자로 입력했습니다";
        assertThatThrownBy(()->new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_SEPERATOR_INPUT);
    }

    @Test
    void 구분자가_빼기면_예외_발생(){
        String input="//-\\n123";
        String MINUS_SEPERATOR_INPUT="마이너스 구분자를 입력했습니다";

        assertThatThrownBy(()->new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MINUS_SEPERATOR_INPUT);
    }

    @Test
    void 음수를_입력했을때_예외_발생(){
        String input="//!\\n-34";
        String NEGATIVE_INPUT="음수를 입력했습니다";

        assertThatThrownBy(()->new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_INPUT);
    }





}